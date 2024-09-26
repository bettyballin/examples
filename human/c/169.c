#include <openssl/evp.h>
#include <assert.h>

int main() {
    EVP_MD_CTX *evpctx = EVP_MD_CTX_create();
    unsigned char sha[32];
    int sha256Len = 32;
    unsigned int signLen;

    EVP_PKEY *pkey = EVP_PKEY_new();
    // Initialize pkey

    EVP_SignInit_ex(evpctx, EVP_sha256(), NULL);
    EVP_SignUpdate(evpctx, sha, sha256Len);
    assert(1 == EVP_SignFinal(evpctx, NULL, &signLen, pkey));

    EVP_MD_CTX_destroy(evpctx);
    EVP_PKEY_free(pkey);

    return 0;
}