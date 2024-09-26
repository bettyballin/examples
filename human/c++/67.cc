cpp
#include <iostream>
#include <string>
#include <openssl/sha.h>
#include <openssl/rsa.h>

template <typename HashAlgorithm>
class PKCS1v15 {
public:
    virtual ~PKCS1v15() {}
};

template <typename HashAlgorithm>
class RSASS {
public:
    class Signer {
    public:
        Signer(const std::string& privateKey) {
            rsa_ = RSA_new();
            BIO* bio = BIO_new_mem_buf(privateKey.c_str(), privateKey.size());
            PEM_read_bio_RSAPrivateKey(bio, &rsa_, NULL, NULL);
            BIO_free(bio);
        }

        ~Signer() {
            RSA_free(rsa_);
        }

        std::string sign(const std::string& message) {
            unsigned char hash[SHA256_DIGEST_LENGTH];
            SHA256_CTX sha256;
            SHA256_Init(&sha256);
            SHA256_Update(&sha256, message.c_str(), message.size());
            SHA256_Final(hash, &sha256);

            unsigned char signature[RSA_size(rsa_)];
            unsigned int signatureLen = RSA_size(rsa_);
            int status = RSA_private_encrypt(RSA_size(rsa_), hash, signature, rsa_, RSA_PKCS1_PADDING);
            if (status != RSA_size(rsa_)) {
                throw std::runtime_error("RSA_private_encrypt failed");
            }

            return std::string((char*)signature, signatureLen);
        }

    private:
        RSA* rsa_;
    };

    class Verifier {
    public:
        Verifier(const std::string& publicKey) {
            rsa_ = RSA_new();
            BIO* bio = BIO_new_mem_buf(publicKey.c_str(), publicKey.size());
            PEM_read_bio_RSAPublicKey(bio, &rsa_, NULL, NULL);
            BIO_free(bio);
        }

        ~Verifier() {
            RSA_free(rsa_);
        }

        bool verify(const std::string& message, const std::string& signature) {
            unsigned char hash[SHA256_DIGEST_LENGTH];
            SHA256_CTX sha256;
            SHA256_Init(&sha256);
            SHA256_Update(&sha256, message.c_str(), message.size());
            SHA256_Final(hash, &sha256);

            int status = RSA_public_decrypt(signature.size(), (unsigned char*)signature.c_str(), hash, rsa_, RSA_PKCS1_PADDING);
            if (status != RSA_size(rsa_)) {
                throw std::runtime_error("RSA_public_decrypt failed");
            }

            return true;
        }

    private:
        RSA* rsa_;
    };
};

typedef RSASS<PKCS1v15, SHA256>::Signer RSASSA_PKCS1v15_SHA256_Signer;
typedef RSASS<PKCS1v15, SHA256>::Verifier RSASSA_PKCS1v15_SHA256_Verifier;

int main() {
    std::string privateKey = "-----BEGIN RSA PRIVATE KEY-----\n"
                             "MIIEpAIBAAKCAQEAn1pMVSEDO4EPzQxKgAakFxRgMGiewWZFAktenWo5aMt/OIso\n"
                             "3ZF+aZh8gCgYEA9jRgfQvWowpemlaTqci9nKffWXSjNWw9n/4ygZoeX3FjVnjgj\n"
                             "-----END RSA PRIVATE KEY-----";

    std::string publicKey = "-----BEGIN RSA PUBLIC KEY-----\n"
                            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn1pMVSEDO4EPzQxKgAak\n"
                            "FxRgMGiewWZFAktenWo5aMt/OIso3ZF+aZh8gCgYEA9jRgfQvWowpemlaTqci9nK\n"
                            "-----END RSA PUBLIC KEY-----";

    std::string message = "Hello, World!";
    RSASSA_PKCS1v15_SHA256_Signer signer(privateKey);
    std::string signature = signer.sign(message);

    RSASSA_PKCS1v15_SHA256_Verifier verifier(publicKey);
    bool verified = verifier.verify(message, signature);

    std::cout << "Verified: " << (verified ? "Yes" : "No") << std::endl;

    return 0;
}