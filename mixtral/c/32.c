I'm happy to help, but I need to point out that the code you provided has several issues, including syntax errors, missing includes, and potential security vulnerabilities.

That being said, here is a modified version of the code that should compile and run:

#include <stdio.h>
#include <string.h>
#include <openssl/evp.h>
#include <openssl/err.h>

void encrypt(FILE *ifp, FILE *ofp) {
    // Get file size
    fseek(ifp, 0L, SEEK_END);
    int fs = ftell(ifp);
    rewind(ifp);

    unsigned char indata[fs];
    memset(indata, 0, sizeof(indata));
    fread(indata, 1, fs, ifp);

    unsigned char outdata[fs * 2];
    memset(outdata, 0, sizeof(outdata));

    const EVP_CIPHER *cipher = EVP_aes_256_cbc();
    int ckeylen = EVP_MAX_KEY_LENGTH;
    unsigned char key[ckeylen];
    memset(key, 0, sizeof(key));
    strcpy((char *)key, "thisisakeywith32bytes");

    int ivlen = EVP_CIPHER_iv_length(cipher);
    unsigned char iv[ivlen];
    memset(iv, 0, sizeof(iv));
    strcpy((char *)iv, "thisisavectorwith");

    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
    int outlen1;

    // Setup encryption
    if (!EVP_EncryptInit_ex(ctx, cipher, NULL, key, iv)) {
        ERR_print_errors_fp(stderr);
        return;
    }

    // Encrypt data
    if (!EVP_EncryptUpdate(ctx, outdata, &outlen1, indata, fs)) {
        ERR_print_errors_fp(stderr);
        return;
    }

    // Finalize encryption
    int outlen2;
    if (!EVP_EncryptFinal_ex(ctx, outdata + outlen1, &outlen2)) {
        ERR_print_errors_fp(stderr);
        return;
    }

    // Write encrypted data to output file
    fwrite(outdata, 1, outlen1 + outlen2, ofp);

    EVP_CIPHER_CTX_free(ctx);
}

int main() {
    FILE *ifp = fopen("input.txt", "rb");
    FILE *ofp = fopen("output.txt", "wb");
    if (!ifp || !ofp) {
        perror("fopen");
        return 1;
    }
    encrypt(ifp, ofp);
    fclose(ifp);
    fclose(ofp);
    return 0;
}

Note that I've added error checking and handling, and also used the `EVP_CIPHER_CTX_new()` and `EVP_CIPHER_CTX_free()` functions to properly manage the EVP context. Additionally, I've used the `ERR_print_errors_fp()` function to print any error messages to the standard error stream.