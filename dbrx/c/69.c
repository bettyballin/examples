#include <openssl/bn.h>
#include <openssl/err.h>

int main() {
    ERR_load_crypto_strings();

    BIGNUM *p = BN_new();
    if (!BN_generate_prime_ex(p, 1024, 0, NULL, NULL, NULL)) {
        unsigned long error = ERR_get_error();
        char *error_string = ERR_error_string(error, NULL);
        printf("Error generating prime p: %s\n", error_string);
        return 1;
    }

    BIGNUM *q = BN_new();
    if (!BN_generate_prime_ex(q, 512, 0, p, NULL, NULL)) {
        unsigned long error = ERR_get_error();
        char *error_string = ERR_error_string(error, NULL);
        printf("Error generating prime q: %s\n", error_string);
        return 1;
    }

    BN_free(p);
    BN_free(q);
    return 0;
}