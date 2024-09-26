
#include <gmp.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    // Initialize random state with default algorithm
    gmp_randstate_t state;
    gmp_randinit_default(state);

    // Seed the state with an unsigned long int
    gmp_randseed_ui(state, (unsigned long)time(NULL));

    // Initialize a big number to hold the prime
    mpz_t prime;
    mpz_init(prime);

    // Generate a 4096-bit random prime number
    mpz_urandomb(prime, state, 4096);
    mpz_nextprime(prime, prime);

    // Print the prime number
    gmp_printf("4096-bit prime: %Zd\n", prime);

    // Clear memory
    mpz_clear(prime);
    gmp_randclear(state);

    return 0;
