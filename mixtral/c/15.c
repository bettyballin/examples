#include <openssl/evp.h>
#include <openssl/err.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    unsigned char *data;
    int size;
} byte_array_ptr;

byte_array_ptr des3_encrypt(const EVP_CIPHER *cipher, byte_array_ptr key_bytes,
                            const unsigned char *iv, byte_array_ptr plaintext) {
    if ((key_bytes->size != 24))
        return NULL;

    int outlen = (plaintext->size / EVP_CIPHER_block_size(cipher)) +
                 (((plaintext->size % EVP_CIPHER_block_size(cipher) == 0) ? 1 : 2));

    byte_array_ptr ciphertext;

    unsigned char *outbuf = (unsigned char *)malloc(outlen * EVP_CIPHER_block_size(cipher));

    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();

    if (!EVP_EncryptInit_ex(ctx, cipher, NULL, key_bytes->data, iv))
        handleErrors();

    int len = 0;

    if (!EVP_EncryptUpdate(ctx, outbuf + len, &outlen, plaintext->data, plaintext->size)) {
        free(outbuf);
        EVP_CIPHER_CTX_free(ctx);
        handleErrors();
    }

    len += outlen;

    if (!EVP_EncryptFinal_ex(ctx, outbuf + len, &len)) {
        free(outbuf);
        EVP_CIPHER_CTX_free(ctx);
        handleErrors();
    }

    EVP_CIPHER_CTX_free(ctx);

    ciphertext.data = outbuf;
    ciphertext.size = len + outlen;

    return ciphertext;
}

void handleErrors(void) {
    ERR_print_errors_fp(stderr);
    exit(1);
}