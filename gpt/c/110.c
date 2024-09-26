
#include <openssl/bn.h>
#include <openssl/err.h>

int main() {
    int bits = 2048; // Size of the prime number in bits
    int safe = 0; // If set to 1, it will generate a "safe" prime (p such that (p-1)/2 is also prime)
    BN_GENCB *cb = NULL; // Callback structure (can be NULL if no callback is desired)
    BIGNUM *prime = NULL;

    // Initialize OpenSSL's library
    ERR_load_crypto_strings();
    OpenSSL_add_all_algorithms();

    // Allocate memory for the prime number
    prime = BN_new();
    if (prime == NULL) {
        fprintf(stderr, "Error allocating prime\n");
        exit(EXIT_FAILURE);
    }

    // Generate a prime number
    if (BN_generate_prime_ex(prime, bits, safe, NULL
