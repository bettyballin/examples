#include <openssl/crypto.h>
#include <openssl/rsa.h>
#include <openssl/bn.h>

int main() {
    RSA *rsa = RSA_new();
    // ... perform operations with rsa

    // Clear secrets before freeing resources
    unsigned char secret[1024];
    OPENSSL_cleanse(secret, sizeof(secret));
    OPENSSL_cleanse(rsa->n, BN_num_bytes(rsa->n));
    OPENSSL_cleanse(rsa->e, BN_num_bytes(rsa->e));

    RSA_free(rsa);
    return 0;
}