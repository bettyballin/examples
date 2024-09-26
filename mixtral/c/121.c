#include <stdio.h>

unsigned long long mod_exp(unsigned long long base, unsigned long long exponent, unsigned long long modulus) {
    unsigned long long result = 1;
    while (exponent > 0) {
        if (exponent % 2 == 1) {
            result = (result * base) % modulus;
        }
        exponent /= 2;
        base = (base * base) % modulus;
    }
    return result;
}

void decrypt_message(unsigned long long encrypted_message, unsigned long long private_key, unsigned long long modulus) {
    unsigned long long decrypted_message = mod_exp(encrypted_message, private_key, modulus);

    printf("Decrypted Message: ");

    // Convert the integer to ASCII characters
    for (int i=0; i<8 && decrypted_message != 0; ++i) {
        unsigned char ascii_value = (decrypted_message >> (56 - i * 8)) & 0xFF;

        if(ascii_value > 31 && ascii_value < 127){
            printf("%c", ascii_value);
        }
    }

    printf("\n");
}

int main() {
    unsigned long long encrypted_message = 0x1234567890abcdef;
    unsigned long long private_key = 0x1234567890abcdef;
    unsigned long long modulus = 0x1234567890abcdef;

    decrypt_message(encrypted_message, private_key, modulus);

    return 0;
}