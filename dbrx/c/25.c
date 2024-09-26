#include <openssl/bn.h>
#include <stdio.h>

BIGNUM *generate_prime(int bits) {
    BIGNUM *bn = BN_new();
    if (!BN_generate_prime_ex(bn, bits, 0, NULL, NULL, NULL)) {
        BN_free(bn);
        return NULL;
    }
    return bn;
}

int main() {
    int bits = 4096;
    BIGNUM *prime = generate_prime(bits);

    if (prime) {
        char str[1024];
        BN_bn2dec(prime, str);
        printf("Prime number: %s\n", str);
        BN_free(prime);
    }

    return 0;
}