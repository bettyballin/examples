pp
#include <openssl/pem.h>
#include <openssl/rsa.h>
#include <openssl/err.h>
#include <openssl/evp.h>
#include <cstring>
#include <string>
#include <vector>
#include <memory>

class OpenSSLEnvelope {
public:
    static bool EncryptString(const std::string& InStr, const std::string& InPublicKey, std::string& OutString) {
        // Load the public key
        BIO* bio = BIO_new_mem_buf(InPublicKey.data(), -1);
        RSA* rsa = PEM_read_bio_RSA_PUBKEY(bio, NULL, NULL, NULL);
        BIO_free(bio);
        if (!rsa)
            return false;

        // Encrypt the string
        std::unique_ptr<EVP_PKEY, decltype(&EVP_PKEY_free)> pkey(EVP_PKEY_new(), EVP_PKEY
