#include <openssl/evp.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

#define EVP_MAX_KEY_LENGTH 32
#define EVP_MAX_IV_LENGTH 16
#define EVP_MAX_BLOCK_LENGTH 16

// seed the PRNG
int seed_prng() {
    srand(time(NULL));
    RAND_seed(rand(), 32);
    return 1;
}

// select a random key
void select_random_key(char *key, int length) {
    RAND_bytes((unsigned char*)key, length);
}

// select a random IV
void select_random_iv(char *iv, int length) {
    RAND_bytes((unsigned char*)iv, length);
}

int main(int argc,  char *argv[]) {
    EVP_CIPHER_CTX  ctx;
    char            key[EVP_MAX_KEY_LENGTH];
    char            iv[EVP_MAX_IV_LENGTH];
    char            *ct, *out;
    char            final[EVP_MAX_BLOCK_LENGTH];
    char            str[] = "123456789abcdef";
    int             i;

    // seed the PRNG
    if (!seed_prng()) {
        printf("Fatal Error!  Unable to seed the PRNG!\n");
        abort();
    }

    // select a random key and iv
    select_random_key(key, EVP_MAX_KEY_LENGTH);
    select_random_iv(iv, EVP_MAX_IV_LENGTH);

    // initialize the EVP context
    EVP_CIPHER_CTX_init(&ctx);

    // encrypt the string
    EVP_EncryptInit_ex(&ctx, EVP_bf_cbc(), NULL, (unsigned char*)key, (unsigned char*)iv);
    ct = encrypt_example(&ctx, str, strlen(str), &i);
    printf("Ciphertext is %d bytes.\n", i);

    // decrypt the string
    EVP_DecryptInit_ex(&ctx, EVP_bf_cbc(), NULL, (unsigned char*)key, (unsigned char*)iv);
    out = decrypt_example(&ctx, ct, 8);
    printf("Decrypted: >>%s<<\n", out);
    out = decrypt_example(&ctx, ct + 8, 8);
    printf("Decrypted: >>%s<<\n", out);

    // finalize the decryption
    if (!EVP_DecryptFinal_ex(&ctx, (unsigned char*)final, &i)) {
        printf("Padding incorrect.\n");
        abort();
    }
    final[i] = 0;
    printf("Decrypted: >>%s<<\n", final);

    // clean up
    EVP_CIPHER_CTX_cleanup(&ctx);
    free(ct);
    free(out);
    return 0;
}

char *encrypt_example(EVP_CIPHER_CTX *ctx, char *data, int inl, int *rb) {
    char *ret;
    int i, tmp, ol;
    ol = 0;
    ret = (char *)malloc(inl + EVP_CIPHER_CTX_block_size(ctx));
    for (i = 0; i < inl / 100; i++) {
        EVP_EncryptUpdate(ctx, (unsigned char*)&ret[ol], &tmp, (unsigned char*)&data[ol], 100);
        ol += tmp;
    }
    if (inl % 100) {
        EVP_EncryptUpdate(ctx, (unsigned char*)&ret[ol], &tmp, (unsigned char*)&data[ol], inl%100);
        ol += tmp;
    }
    EVP_EncryptFinal_ex(ctx, (unsigned char*)&ret[ol], &tmp);
    *rb = ol + tmp;
    return ret;
}

char *decrypt_example(EVP_CIPHER_CTX *ctx, char *ct, int inl) {
    /* We're going to null-terminate the plaintext under the assumption it's
     * non-null terminated ASCII text. The null can be ignored otherwise.
     */
    char *pt = (char *)malloc(inl + EVP_CIPHER_CTX_block_size(ctx) + 1);
    int ol;
    EVP_DecryptUpdate(ctx, (unsigned char*)pt, &ol, (unsigned char*)ct, inl);
    if (!ol) /* there's no block to decrypt */
    {
        free(pt);
        return NULL;
    }
    pt[ol] = 0;
    return pt;
}