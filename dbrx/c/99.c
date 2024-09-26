#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <openssl/err.h>
#include <string>
#include <fstream>

bool EncryptString(const std::string& InStr, const std::string& PublicKeyPath, std::string& OutEncrypted) {
    // Read public key from file.
    FILE* fp = fopen(PublicKeyPath.c_str(), "r");
    if (!fp)
        return false;

    EVP_PKEY* pkey = PEM_read_PUBKEY(fp, nullptr, nullptr, nullptr);
    fclose(fp);

    if (!pkey) {
        ERR_print_errors_fp(stderr);
        return false;
    }

    // Initialize context.
    EVP_PKEY_CTX* ctx = EVP_PKEY_CTX_new(pkey, nullptr);
    int ret = 0;

    if (ctx != NULL)
       ret = EVP_PKEY_encrypt_init(ctx);

    if (!ret) {
        ERR_print_errors_fp(stderr);
        EVP_PKEY_free(pkey);
        return false;
    }

    // Set padding scheme.
    const unsigned char* oaep_label = nullptr; 
    size_t label_len = 0;
    int rsa_padding = RSA_PKCS1_OAEP_PADDING;

    ret = EVP_PKEY_CTX_set_rsa_padding(ctx, rsa_padding);

    if (ret <= 0) {
        ERR_print_errors_fp(stderr);
        EVP_PKEY_CTX_free(ctx);
        EVP_PKEY_free(pkey);
        return false;
    }

    // Encrypt data.
    size_t outlen = 256; // Adjust this based on your key length.

    OutEncrypted.resize(outlen); 

    ret = EVP_PKEY_encrypt(ctx, reinterpret_cast<unsigned char*>(&OutEncrypted[0]), &outlen, reinterpret_cast<const unsigned char*>(InStr.c_str()), InStr.size());

    if (ret <= 0) {
        ERR_print_errors_fp(stderr);
        EVP_PKEY_CTX_free(ctx);
        EVP_PKEY_free(pkey);
        return false;
     }

     OutEncrypted.resize(outlen);

     EVP_PKEY_CTX_free(ctx);
     EVP_PKEY_free(pkey);

     return true;
}

int main() {
    std::string publicKeyPath = "public_key.pem";
    std::string inStr = "Hello, World!";
    std::string outEncrypted;

    if (EncryptString(inStr, publicKeyPath, outEncrypted)) {
        std::cout << "Encrypted string: " << outEncrypted << std::endl;
    } else {
        std::cerr << "Encryption failed." << std::endl;
    }

    return 0;
}