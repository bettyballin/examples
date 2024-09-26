#include <stdio.h>
#include <openssl/aes.h>

int main() {
    // Assuming inputslength, ticket, enc_out, enc_key, and iv_enc are defined
    size_t inputslength = 1024; // Example length
    unsigned char ticket[inputslength];
    unsigned char enc_out[inputslength];
    AES_KEY enc_key;
    unsigned char iv_enc[AES_BLOCK_SIZE];

    // Initialize ticket, enc_key, and iv_enc
    for (size_t i = 0; i < inputslength; i++) {
        ticket[i] = i % 256;
    }
    AES_set_encrypt_key((const unsigned char *)"0123456789012345", 128, &enc_key);
    for (size_t i = 0; i < AES_BLOCK_SIZE; i++) {
        iv_enc[i] = 0;
    }

    size_t fullBlocks = inputslength - (inputslength % AES_BLOCK_SIZE);
    size_t remainingBlock = inputslength - fullBlocks;

    AES_cbc_encrypt((unsigned char *)&ticket, enc_out, fullBlocks, &enc_key, iv_enc, AES_ENCRYPT);
    AES_cbc_encrypt((unsigned char *)&ticket + fullBlocks, enc_out + fullBlocks, remainingBlock, &enc_key, iv_enc, AES_ENCRYPT);

    return 0;
}