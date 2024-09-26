#include <gmp.h>
#include <stdio.h>
#include <math.h>

int main() {
    mpz_t base10;
    mpz_init(base10);

    mpz_set_ui(base10, 19);
    mpz_addmul_ui(base10, pow(58, 0), 'L');
    mpz_addmul_ui(base10, pow(58, 1), 'Q');
    mpz_addmul_ui(base10, pow(58, 2), 'k');
    mpz_addmul_ui(base10, pow(58, 3), 'u');
    mpz_addmul_ui(base10, pow(58, 4), 'B');

    gmp_printf("base10 = %Zd\n", base10);

    mpz_clear(base10);
    return 0;
}