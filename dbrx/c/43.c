#include <stdio.h>
#include <stdlib.h>
#include <openssl/rsa.h>
#include <openssl/bn.h>

int main() {
    RSA *rsa = RSA_new();
    const BIGNUM *bn_n = RSA_get0_key(rsa, NULL, NULL);
    unsigned char n[256];
    int len = BN_bn2bin(bn_n, n);

    printf("Length of public key component N: %d bytes\n", len);
    printf("Binary representation of public key component N: ");
    for (int i = 0; i < len; i++) {
        printf("%02x", n[i]);
    }
    printf("\n");

    RSA_free(rsa);
    return 0;
}