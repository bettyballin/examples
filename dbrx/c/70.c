#include <openssl/bn.h>

int main() {
    BIGNUM *p = BN_new();
    BN_set_word(p, 23); // test with a prime number

    if (!BN_is_prime_ex(p, 10 /* number of Miller-Rabin tests */, NULL, BN_CTX_new())) {
        // handle error
        printf("Error: %s is not a prime number\n", BN_bn2dec(p));
    } else {
        printf("%s is a prime number\n", BN_bn2dec(p));
    }

    BN_free(p);
    return 0;
}