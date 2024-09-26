#include <openssl/rsa.h>
#include <openssl/err.h>
#include <stdlib.h>
#include <string.h>

#define RSA_LEN 2048
#define RSA_FACTOR 65537

int genRSA2048(unsigned char **pub, unsigned int *pub_len,
               unsigned char **priv, unsigned int *priv_len) {
    RSA *pRSAPrivateKey = NULL;

    pRSAPrivateKey = RSA_generate_key(RSA_LEN, RSA_FACTOR, NULL, NULL);

    if (pRSAPrivateKey != NULL){
        // Allocate memory for the length variables
        *pub_len  = i2d_RSAPublicKey(pRSAPrivateKey, NULL);

        unsigned char* tempPub = (unsigned char*)malloc(*pub_len);
        unsigned char* tempPriv;

        *priv_len   = i2d_RSAPrivateKey(pRSAPrivateKey, &tempPriv);

        // Allocate memory for the private key
        if ((*pub  = (unsigned char*)malloc(*pub_len)) == NULL ||
            (*priv = (unsigned char*)malloc(*priv_len)) == NULL) {

                RSA_free(pRSAPrivateKey);

                // Free allocated memory in case of error

             if ((*pub != NULL)){
                 free((void *) *pub);
              }

            return -1;
        }

        i2d_RSAPublicKey(pRSAPrivateKey, &tempPub);
        memcpy(*pub, tempPub, *pub_len);
        free(tempPub);

        memcpy(*priv, tempPriv, *priv_len);

        RSA_free(pRSAPrivateKey);

        // Free the temporary private key buffer

        OPENSSL_free((void *)tempPriv);

        return 0;

    } else {

        return -1;

    }
}

int main() {
    unsigned char *pub = NULL, *priv = NULL;
    unsigned int pub_len, priv_len;

    if(genRSA2048(&pub, &pub_len, &priv, &priv_len) == 0) {
        // Use pub and priv
        printf("Public key length: %u\n", pub_len);
        printf("Private key length: %u\n", priv_len);

        free(pub);
        free(priv);
    }

    return 0;
}