#include <openssl/evp.h>
#include <openssl/sha.h>

int main() {
    EVP_MD_CTX *evpctx = EVP_MD_CTX_create();
    unsigned char sha[SHA256_DIGEST_LENGTH];
    unsigned char sig[256];
    size_t sha256Len = SHA256_DIGEST_LENGTH;
    size_t signLen = 256;

    // Initialize evpctx and sha

    EVP_PKEY *pkey; // Load private key

    int ret = EVP_PKEY_sign(evpctx, sig, &signLen, sha, sha256Len);

    EVP_MD_CTX_destroy(evpctx);

    return ret;
}