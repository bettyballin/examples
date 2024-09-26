#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/evp.h>

int main() {
    unsigned char key[32] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1'}; // Your AES-256 Key
    unsigned char iv[8] = {'0', '1', '2', '3', '4', '5', '6', '7'};   // Your Initialization Vector

    int outlen, inlen;
    char text[] = "Your plaintext here";
    unsigned char outbuf[sizeof(text) + EVP_MAX_BLOCK_LENGTH];

    EVP_CIPHER_CTX ctx;

    if (!EVP_EncryptInit_ex(&ctx, EVP_aes_256_cfb8(), NULL, key, iv)) {
        printf("EVP_EncryptInit_ex failed\n");
        return 1;
    }

    int i = 0;
    for (i=0 ; i < sizeof(text) -1 ; i++)
    {
        if(!EVP_EncryptUpdate(&ctx, outbuf + i, &outlen, (unsigned char*)text+i, 1)) {
            printf("EVP_EncryptUpdate failed\n");
            return 1;
        }
    }

    if (!EVP_EncryptFinal(&ctx, outbuf + i, &outlen)){
        printf("EVP_EncryptFinal failed\n");
        return 1;
    }

    // Clean up
    EVP_CIPHER_CTX_cleanup(&ctx);

    // Print the ciphertext
    printf("Ciphertext: ");
    for (i = 0; i < sizeof(text) + EVP_MAX_BLOCK_LENGTH; i++) {
        printf("%02x", outbuf[i]);
    }
    printf("\n");

    return 0;
}