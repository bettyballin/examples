#include <gmp.h>
#include <stdio.h>
#include <stdlib.h>

void generate_prime(int bits, mpz_t prime) {
  gmp_randstate_t state;
  gmp_randinit_mt(state);
  gmp_randseed_ui(state, (unsigned int) time(NULL));

  do {
    // Generate a random number
    if (!mpz_rrandomb(prime, state, bits))
      continue;

    // Make sure the generated number is odd
    while (mpz_even_p(prime) != 0)
      mpz_sub_ui(prime, prime, 1);

    // Check if it's a probable prime
  } while (!mpz_probab_prime_p(prime, 25));
}

int main() {
  mpz_t prime;
  mpz_init(prime);
  generate_prime(1024, prime);
  gmp_printf("%Zd\n", prime);
  mpz_clear(prime);
  return 0;
}