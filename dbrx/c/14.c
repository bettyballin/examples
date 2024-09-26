#include <stdio.h>
#include <openssl/des.h>

int main() {
    DES_cblock data_to_encrypt = {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08};
    DES_cblock encrypted_data;
    DES_key_schedule encrypt_schedule;
    DES_key_schedule decrypt_schedule;
    DES_set_key((const_DES_cblock*) "01234567", &encrypt_schedule);
    DES_set_key((const_DES_cblock*) "01234567", &decrypt_schedule);

    DES_ecb3_encrypt(&data_to_encrypt, &encrypted_data, &encrypt_schedule, &decrypt_schedule, 1);

    printf("Encrypted data: ");
    for (int i = 0; i < sizeof(DES_cblock); ++i) {
        printf("%02X ", encrypted_data[i]);
    }
    printf("\n");

    return 0;
}