#include <stdint.h>
#include <ecc.h>

int ecc_make_key(uint8_t p_publicKey[ECC_BYTES+1], uint8_t p_privateKey[ECC_BYTES]) {
    // Your implementation here
    return 0;
}

int main() {
    uint8_t publicKey[ECC_BYTES+1];
    uint8_t privateKey[ECC_BYTES];
    ecc_make_key(publicKey, privateKey);
    return 0;
}