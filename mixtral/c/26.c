#include <openssl/bn.h>
#include <stdio.h>

BIGNUM *generate_prime(int bits) {
    BN_CTX *ctx = BN_CTX_new();
    BIGNUM *p = NULL;

    do {
        p = BN_new();

        if (!BN_rand(p, bits, BN_RAND_TOP_ANY, BN_RAND_BOTTOM_ODD) ||
            !BN_is_prime_ex(p, 10, ctx, NULL)) {

            // Free the memory and try again
            if (p != NULL)
                BN_free(p);

        } else

            break;
    } while (1);

    BN_CTX_free(ctx);
    return p;
}

int main() {
    BIGNUM *prime = generate_prime(256);
    if (prime) {
        char *prime_str = BN_bn2hex(prime);
        printf("Generated prime: %s\n", prime_str);
        OPENSSL_free(prime_str);
        BN_free(prime);
    } else {
        printf("Failed to generate prime\n");
    }
    return 0;
}