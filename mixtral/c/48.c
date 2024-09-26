#include <openssl/rsa.h>
#include <openssl/crypto.h>
#include <string.h>
#include <stdio.h>

int main() {
    RSA *rsa = NULL;
    // ... initialize and use rsa

    /* Clear secret */
    if (rsa) {
        // Zeroize all private data
        if(rsa->d != NULL){
            OPENSSL_cleanse((void *)rsa->d, sizeof(*rsa->d));
        }
        RSA_free(rsa);

        /* Clear the rest of rsa */
        rsa = NULL;
    }

    return 0;
}