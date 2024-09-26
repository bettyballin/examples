#include <iostream>
#include <string>
#include <vector>
#include <openssl/evp.h>
#include <openssl/err.h>

void handleOpenSSLErrors() {
    ERR_print_errors_fp(stderr);
    exit(1);
}

std::string decrypt(unsigned char *ciphertext, int ciphertext_len, unsigned char *key, unsigned char *iv) {
    EVP_CIPHER_CTX *ctx;
    std::vector<unsigned char> plaintext(ciphertext_len);

    if(!(ctx = EVP_CIPHER_CTX_new())) handleOpenSSLErrors();

    if (1 != EVP_DecryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, key, iv))
        handleOpenSSLErrors();

    int len;

    if (1 != EVP_DecryptUpdate(ctx, plaintext.data(), &len, ciphertext, ciphertext_len))
        handleOpenSSLErrors();

    size_t plaintext_len = static_cast<size_t>(len);

    if (1 != EVP_DecryptFinal_ex(ctx, plaintext.data() + len, &len))
        handleOpenSSLErrors();

    plaintext_len += static_cast<size_t>(len);

    EVP_CIPHER_CTX_free(ctx);

    return std::string(plaintext.data(), plaintext_len);
}

int main() {
    // Example usage:
    unsigned char ciphertext[] = "your ciphertext here";
    int ciphertext_len = sizeof(ciphertext);
    unsigned char key[] = "your key here";
    unsigned char iv[] = "your iv here";

    std::string plaintext = decrypt(ciphertext, ciphertext_len, key, iv);
    std::cout << plaintext << std::endl;

    return 0;
}