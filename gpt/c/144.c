
#include <openssl/bn.h>
#include <openssl/evp.h>
#include <openssl/sha.h>

int hash_bignums(const BIGNUM *bns[], size_t num_bns, unsigned char *output) {
    EVP_MD_CTX *ctx;
    size_t i;
    int bn_size, result = 0;
    unsigned char *buf;

    // Create and initialize the context
    if(!(ctx = EVP_MD_CTX_new())) {
        return 0;
    }

    if(EVP_DigestInit_ex(ctx, EVP_sha256(), NULL) != 1) {
        goto cleanup;
    }

   
