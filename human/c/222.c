#include <openssl/pem.h>
#include <string>
#include <iostream>

bool EncryptString(const std::string& InStr /*plaintext*/, const std::string& InPublicKey /*path to public key pem file*/, std::string& OutString /*ciphertext*/) {
    
    // Load key
    FILE* f = fopen(InPublicKey.c_str(), "r");
    if (!f) {
        std::cerr << "Error opening public key file" << std::endl;
        return false;
    }
    EVP_PKEY* pkey = PEM_read_PUBKEY(f, NULL, NULL, NULL);
    fclose(f);
    if (!pkey) {
        std::cerr << "Error reading public key" << std::endl;
        return false;
    }
    
    // Create/initialize context
    EVP_PKEY_CTX* ctx;
    ctx = EVP_PKEY_CTX_new(pkey, NULL);
    if (!ctx) {
        std::cerr << "Error creating context" << std::endl;
        EVP_PKEY_free(pkey);
        return false;
    }
    if (EVP_PKEY_encrypt_init(ctx) != 1) {
        std::cerr << "Error initializing context" << std::endl;
        EVP_PKEY_CTX_free(ctx);
        EVP_PKEY_free(pkey);
        return false;
    }

    // Specify padding: default is PKCS#1 v1.5
    // EVP_PKEY_CTX_set_rsa_padding(ctx, RSA_PKCS1_OAEP_PADDING); // for OAEP with SHA1 for both digests

    // Encryption
    size_t ciphertextLen;
    if (EVP_PKEY_encrypt(ctx, NULL, &ciphertextLen, (const unsigned char*)InStr.c_str(), InStr.size()) != 1) {
        std::cerr << "Error getting ciphertext length" << std::endl;
        EVP_PKEY_CTX_free(ctx);
        EVP_PKEY_free(pkey);
        return false;
    }
    unsigned char* ciphertext = (unsigned char*)OPENSSL_malloc(ciphertextLen);
    if (!ciphertext) {
        std::cerr << "Error allocating memory" << std::endl;
        EVP_PKEY_CTX_free(ctx);
        EVP_PKEY_free(pkey);
        return false;
    }
    if (EVP_PKEY_encrypt(ctx, ciphertext, &ciphertextLen, (const unsigned char*)InStr.c_str(), InStr.size()) != 1) {
        std::cerr << "Error encrypting" << std::endl;
        OPENSSL_free(ciphertext);
        EVP_PKEY_CTX_free(ctx);
        EVP_PKEY_free(pkey);
        return false;
    }
    OutString.assign((char*)ciphertext, ciphertextLen);

    // Release memory
    EVP_PKEY_free(pkey);
    EVP_PKEY_CTX_free(ctx);
    OPENSSL_free(ciphertext);

    return true;
}

int main() {
    std::string plaintext = "Hello, World!";
    std::string publicKeyPath = "public_key.pem";
    std::string ciphertext;

    if (EncryptString(plaintext, publicKeyPath, ciphertext)) {
        std::cout << "Ciphertext: " << ciphertext << std::endl;
    } else {
        std::cerr << "Encryption failed" << std::endl;
    }

    return 0;
}