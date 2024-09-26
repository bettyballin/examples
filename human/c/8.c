#include <stdio.h>
#include <openssl/rsa.h>
#include <openssl/pem.h>

RSA *PEM_read_RSAPrivateKey(FILE *fp, RSA **x, pem_password_cb *cb, void *u) {
    return PEM_read_RSAPrivateKey(fp, x, cb, u);
}

RSA *PEM_read_RSAPublicKey(FILE *fp, RSA **x, pem_password_cb *cb, void *u) {
    return PEM_read_RSAPublicKey(fp, x, cb, u);
}

int main() {
    FILE *fp;
    RSA *rsa;

    // Open private key file
    fp = fopen("private_key.pem", "r");
    if (fp == NULL) {
        printf("Error opening file\n");
        return 1;
    }

    // Read private key
    rsa = PEM_read_RSAPrivateKey(fp, NULL, NULL, NULL);
    if (rsa == NULL) {
        printf("Error reading private key\n");
        fclose(fp);
        return 1;
    }

    // Close file
    fclose(fp);

    // Open public key file
    fp = fopen("public_key.pem", "r");
    if (fp == NULL) {
        printf("Error opening file\n");
        RSA_free(rsa);
        return 1;
    }

    // Read public key
    RSA *rsa_pub = PEM_read_RSAPublicKey(fp, NULL, NULL, NULL);
    if (rsa_pub == NULL) {
        printf("Error reading public key\n");
        fclose(fp);
        RSA_free(rsa);
        return 1;
    }

    // Close file
    fclose(fp);

    // Free RSA structures
    RSA_free(rsa);
    RSA_free(rsa_pub);

    return 0;
}