Here is the corrected and executable code:


#include <openssl/bn.h>
#include <openssl/rand.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    BIGNUM  *bn1 = NULL;
    BIGNUM  *bn2 = NULL;
    BN_CTX  *ctx = BN_CTX_new();
    BIGNUM  *r   = BN_new();

    static const char rnd_seed[] =
        "string to make the random number generator think it has entropy";
    RAND_seed(rnd_seed, sizeof rnd_seed); /* or BN_generate_prime_ex may fail */

    if (!BN_generate_prime_ex(r, 1024, 0, NULL, NULL, ctx)) {
        fprintf(stderr, "[!] Failed generating prime for Elgamal encryption.\n");
        goto cleanup;
    }

    bn1 = BN_new();
    bn2 = BN_new();

    /* Generate random numbers within the range of r */
    if (!BN_rand_range(bn1, r) || !BN_rand_range(bn2, r)) {
        fprintf(stderr, "[!] Failed generating random number for Elgamal encryption.\n");
        goto cleanup;
    }

    BIGNUM *result = BN_new();
    /* Perform multiplication and exponentiation */
    if (!BN_mul(result, bn1, bn2, ctx) || !BN_exp(result, bn2, bn1, ctx)) {
        fprintf(stderr, "[!] Failed performing Elgamal encryption operations.\n");
       goto cleanup;
    }

cleanup:
    BN_free(bn1);
    BN_free(bn2);
    BN_free(result);
    BN_free(r);
    BN_CTX_free(ctx);

    return 0;
}


Please compile with:
bash
gcc -o output_file your_file.c -lssl -lcrypto