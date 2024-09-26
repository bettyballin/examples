#include <stdio.h>
#include <openssl/bn.h>

int main() {
    BIGNUM *safe_p = BN_new();
    int bitsize = 1024; // or any other size you want

    if (!BN_generate_prime_ex(safe_p, bitsize, 1, NULL, NULL, NULL)) {
        fprintf(stderr, "Error generating safe prime\n");
    }

    BN_free(safe_p);
    return 0;
}