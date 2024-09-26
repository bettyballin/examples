Here is the modified C code:


#include <openssl/ec.h>
#include <openssl/evp.h>
#include <assert.h>
#include <string.h>

int main(void) {
    // Generate EC Key
    EC_KEY* eckey = EC_KEY_new_by_curve_name(NID_X9_62_prime256v1);
    assert(EC_KEY_generate_key(eckey));

    EVP_MD_CTX* ctx;
    // Create a new context for the operation
    ctx = EVP_MD_CTX_create();

    unsigned char msg[] = "Hello World!";
    size_t msglen = strlen((char*)msg);

    const int sha256Len = 32;

    // Initialize context for signing
    assert(EVP_DigestSignInit(ctx, NULL, EVP_sha256(), NULL, eckey) == 1);

    unsigned char sig[4098];
    size_t signlen = sizeof(sig);

    // Sign the message
    assert(EVP_DigestSignUpdate(ctx, msg, msglen) == 1);
    assert(EVP_DigestSignFinal(ctx, sig, &signlen) == 1);

    EVP_MD_CTX* verificationContext;
    // Create a new context for verification
    verificationContext = EVP_MD_CTX_create();

    int verifyResult = -1;
    assert(EVP_DigestVerifyInit(verificationContext, NULL, EVP_sha256(), NULL, eckey) == 1);

    // Verify the signature
    assert(EVP_DigestVerifyUpdate(verificationContext, msg, msglen) == 1);
    verifyResult = EVP_DigestVerifyFinal(verificationContext, sig, signlen);

    if (verifyResult == 1) {
        printf("Verification successful!\n");
    } else {
        printf("Verification failed!\n");
    }

    EVP_MD_CTX_destroy(ctx);
    EVP_MD_CTX_destroy(verificationContext);
    EC_KEY_free(eckey);

    return 0;
}