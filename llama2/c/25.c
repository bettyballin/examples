#include <openssl/aes.h>
#include <openssl/err.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    // Initialize the encryption context
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
    if (ctx == NULL)
    {
        printf("Error: %s\n", ERR_error_string(ERR_get_error(), NULL));
        exit(1);
    }

    // Set the cipher and key
    unsigned char key[] = "0123456789abcdef";
    unsigned char iv[] = "0123456789abcdef";
    if (EVP_EncryptInit_ex(ctx, EVP_aes_128_cbc(), NULL, key, iv) != 1)
    {
        printf("Error: %s\n", ERR_error_string(ERR_get_error(), NULL));
        EVP_CIPHER_CTX_free(ctx);
        exit(1);
    }

    // Set the input and output buffers
    unsigned char in[] = "Hello, World!";
    unsigned char out[1024];
    int outlen;

    // Encrypt the input
    if (EVP_EncryptUpdate(ctx, out, &outlen, in, strlen((char*)in)) != 1)
    {
        printf("Error: %s\n", ERR_error_string(ERR_get_error(), NULL));
        EVP_CIPHER_CTX_free(ctx);
        exit(1);
    }

    // Finalize the encryption
    if (EVP_EncryptFinal_ex(ctx, out + outlen, &outlen) != 1)
    {
        printf("Error: %s\n", ERR_error_string(ERR_get_error(), NULL));
        EVP_CIPHER_CTX_free(ctx);
        exit(1);
    }

    // Print the encrypted output
    printf("Encrypted: ");
    for (int i = 0; i < outlen; i++)
    {
        printf("%02x", out[i]);
    }
    printf("\n");

    // Clean up
    EVP_CIPHER_CTX_free(ctx);
    return 0;
}