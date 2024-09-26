cpp
#include <iostream>
#include <stdexcept>
#include <openssl/dh.h>

int main() {
    DH* dhB = DH_new();
    unsigned char* shared_secret_buf = new unsigned char[DH_size(dhB)];
    BIGNUM* privB = BN_new();
    BIGNUM* pubA = BN_new();

    // Initialize dhB, privB and pubA
    DH_generate_parameters_ex(dhB, 2048, DH_GENERATOR_5, NULL);
    DH_generate_key(dhB);
    BN_bin2bn((const unsigned char*)DH_get0_priv_key(dhB), DH_size(dhB), privB);
    BN_bin2bn((const unsigned char*)DH_get0_pub_key(dhB), DH_size(dhB), pubA);

    if(!DH_compute_key(shared_secret_buf, pubA, dhB)) {
        throw std::runtime_error("Failed to reach shared secret (B)");
    }

    delete[] shared_secret_buf;
    BN_free(privB);
    BN_free(pubA);
    DH_free(dhB);

    return 0;
}