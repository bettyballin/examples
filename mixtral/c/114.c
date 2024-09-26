#include <gmp.h>

int main() {
    mpz_t result;
    // Initialize it
    mpz_init(result);

    /* Perform operations on 'result' */
    mpz_set_ui(result, 42); // Example operation

    gmp_printf("%Zd\n", result); // Print the result

    // Don’t forget to clear the memory when you are done
    mpz_clear(result);

    return 0;
}