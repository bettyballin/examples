cpp
#include <iostream>
#include <string>
#include <openssl/rsa.h>
#include <openssl/sha.h>

// Define RSASS class template
template <typename Padding, typename Hash>
class RSASS {
public:
    class Signer {
    public:
        Signer(RSA* rsa) : rsa_(rsa) {}
        ~Signer() { RSA_free(rsa_); }
        std::string sign(const std::string& message) {
            unsigned char hash[Hash::digest_size];
            Hash::hash(message, hash);
            unsigned char signature[RSA_size(rsa_)];
            unsigned int signature_len = RSA_size(rsa_);
            Padding::pad(rsa_, hash, Hash::digest_size, signature, &signature_len);
            return std::string((char*)signature, signature_len);
        }
    private:
        RSA* rsa_;
    };

    class Verifier {
    public:
        Verifier(RSA* rsa) : rsa_(rsa) {}
        ~Verifier() { RSA_free(rsa_); }
        bool verify(const std::string& message, const std::string& signature) {
            unsigned char hash[Hash::digest_size];
            Hash::hash(message, hash);
            return Padding::verify(rsa_, hash, Hash::digest_size, (unsigned char*)signature.c_str(), signature.size());
        }
    private:
        RSA* rsa_;
    };
};

// Define PKCS1v15 padding scheme
class PKCS1v15 {
public:
    static void pad(RSA* rsa, const unsigned char* hash, size_t hash_len, unsigned char* signature, unsigned int* signature_len) {
        RSA_sign(NID_sha1, hash, hash_len, signature, signature_len, rsa);
    }
    static bool verify(RSA* rsa, const unsigned char* hash, size_t hash_len, const unsigned char* signature, size_t signature_len) {
        return RSA_verify(NID_sha1, hash, hash_len, signature, signature_len, rsa) == 1;
    }
};

// Define SHA hash function
class SHA {
public:
    static const size_t digest_size = SHA_DIGEST_LENGTH;
    static void hash(const std::string& message, unsigned char* hash) {
        SHA_CTX ctx;
        SHA1_Init(&ctx);
        SHA1_Update(&ctx, message.c_str(), message.size());
        SHA1_Final(hash, &ctx);
    }
};

// Define RSASSA_PKCS1v15_SHA_Signer and RSASSA_PKCS1v15_SHA_Verifier types
typedef RSASS<PKCS1v15, SHA>::Signer RSASSA_PKCS1v15_SHA_Signer;
typedef RSASS<PKCS1v15, SHA>::Verifier RSASSA_PKCS1v15_SHA_Verifier;

int main() {
    // Create RSA key pair
    RSA* rsa = RSA_new();
    BIGNUM* exponent = BN_new();
    BN_set_word(exponent, 65537);
    RSA_generate_key_ex(rsa, 2048, exponent, NULL);

    // Create signer and verifier
    RSASSA_PKCS1v15_SHA_Signer signer(rsa);
    RSASSA_PKCS1v15_SHA_Verifier verifier(rsa);

    // Sign a message
    std::string message = "Hello, World!";
    std::string signature = signer.sign(message);

    // Verify the signature
    if (verifier.verify(message, signature)) {
        std::cout << "Signature verified successfully." << std::endl;
    } else {
        std::cout << "Signature verification failed." << std::endl;
    }

    return 0;
}