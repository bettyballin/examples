#include <iostream>
#include <openssl/bn.h>

int main() {
    BIGNUM *eccsig_r = nullptr;
    BN_CTX *ctx = BN_CTX_new();
    if (ctx == NULL) {
        std::cerr << "Error creating BN_CTX" << std::endl;
        return 1;
    }

    eccsig_r = BN_new();  // allocate memory for BIGNUM object
    if (eccsig_r == NULL) {
        std::cerr << "Error creating BIGNUM" << std::endl;
        BN_CTX_free(ctx);
        return 1;
    }

    unsigned char out[33] = { /* initialize with some value */ };

    // convert bytes to a BIGNUM object
    int ret_val = BN_bin2bn(&out[1], 32, eccsig_r);
    if (ret_val != 0) {
        std::cout << "Conversion successful" << std::endl;
    } else {
        std::cerr << "Error converting to BIGNUM" << std::endl;
    }

    std::cout << eccsig_r << std::endl;

    BN_free(eccsig_r);   // free memory allocated for BIGNUM object
    BN_CTX_free(ctx);

    return 0;
}