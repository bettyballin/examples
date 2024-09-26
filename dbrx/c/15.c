#include <stdio.h>
#include <openssl/des.h>

int main() {
    DES_cblock encrypted_data;
    DES_cblock decrypted_data;
    DES_key_schedule decrypt_schedule;
    DES_key_schedule encrypt_schedule;

    // Initialize encrypted_data, decrypt_schedule, and encrypt_schedule
    // ...

    DES_ecb3_encrypt(&encrypted_data, &decrypted_data, &decrypt_schedule, &encrypt_schedule, 1);

    printf("Decrypted data: ");
    for (int i = 0; i < sizeof(DES_cblock); ++i) {
        printf("%02X ", decrypted_data[i]);
    }
    printf("\n");

    return 0;
}