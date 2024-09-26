
#include <stdio.h>

unsigned long long mod_exp(unsigned long long base, unsigned long long exponent, unsigned long long modulus) {
    unsigned long long result = 1;
    while (exponent > 0) {
        if (exponent & 1) {
            result = (result * base) % modulus;
        }
        base = (base * base) % modulus;
        exponent >>= 1;
    }
    return result;
}

void decrypt_message(unsigned long long encrypted_message, unsigned long long private_key, unsigned long long modulus)
