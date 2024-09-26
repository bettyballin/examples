#include <openssl/aes.h>
#include <string.h>
#include <stdio.h>

int main() {
    EVP_CIPHER_CTX ctx;
    unsigned char key[] = "password";
    unsigned char iv[AES_BLOCK_SIZE];
    memset(iv, 0x00, AES_BLOCK_SIZE);
    int outlen;

    // Initialize context and set padding
    EVP_CIPHER_CTX_init(&ctx);
    EVP_CipherInit_ex(&ctx, EVP_aes_128_ecb(), NULL, key, iv, 1);
    EVP_CIPHER_CTX_set_padding(&ctx, 0);

    unsigned char plaintext[] = "Hello World!";
    int plainlen = strlen(plaintext);
    
    // Allocate output buffer
    unsigned char ciphertext[plainlen + AES_BLOCK_SIZE];
    memset(ciphertext, 0x00, sizeof(ciphertext));

    // Encrypt data without padding
    EVP_CipherUpdate(&ctx, ciphertext, &outlen, plaintext, plainlen);

    // Finalize encryption (not needed here)
    //EVP_CipherFinal_ex(&ctx, ciphertext + outlen, &tmp);
    
    printf("Ciphertext: ");
    for(int i = 0; i < outlen; ++i) {
        if(i != 0 && i % AES_BLOCK_SIZE == 0) 
            printf("\n");
        else
            printf("%02x ", ciphertext[i]);
    }
    printf("\n");

    EVP_CIPHER_CTX_cleanup(&ctx);
    return 0;
}