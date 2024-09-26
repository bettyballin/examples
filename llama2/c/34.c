#include <openssl/ssl.h>
#include <openssl/err.h>
#include <stdio.h>

int main()
{
    // Generate a new RSA key pair
    RSA *rsa;
    rsa = RSA_new();
    if (rsa == NULL)
    {
        unsigned long err = ERR_get_error();
        char *err_str = ERR_error_string(err, NULL);
        printf("Error: %s\n", err_str);
        return 1;
    }

    // Set up the RSA key parameters
    BIGNUM *bne = BN_new();
    BN_set_word(bne, RSA_F4);
    RSA_generate_key_ex(rsa, 2048, bne, NULL);

    // Extract the modulus and public exponent
    BIGNUM *n = BN_new();
    BIGNUM *e = BN_new();
    RSA_get0_key(rsa, n, e, NULL);

    // Use n as the product of two large prime numbers
    // p and q are factors of n
    RSA_factorization *factorization = RSA_factorize(n, NULL);
    if (factorization == NULL)
    {
        unsigned long err = ERR_get_error();
        char *err_str = ERR_error_string(err, NULL);
        printf("Error: %s\n", err_str);
        return 1;
    }
    BIGNUM *p = factorization->p;
    BIGNUM *q = factorization->q;

    // Print p and q
    printf("p: ");
    BN_print_fp(stdout, p);
    printf("\n");
    printf("q: ");
    BN_print_fp(stdout, q);
    printf("\n");

    RSA_free(rsa);
    BN_free(bne);
    BN_free(n);
    BN_free(e);
    RSA_factorization_free(factorization);

    return 0;
}