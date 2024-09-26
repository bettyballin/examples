#include <stdio.h>
#include <openssl/rsa.h>
#include <openssl/err.h>

int main() {
    RSA *rsa = NULL;
    int bits = 4096; // Key size in bits

    // Initialize OpenSSL
    OpenSSL_add_all_algorithms();
    ERR_load_crypto_strings();

    // Allocate memory for the RSA struct
    if ((rsa = RSA_generate_key(bits, RSA_F4, NULL, NULL)) == NULL) {
        fprintf(stderr, "Failed to generate RSA key\n");
        ERR_print_errors_fp(stderr);
    }

    // Clean up
    RSA_free(rsa);
    return 0;
}