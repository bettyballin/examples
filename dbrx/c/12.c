#include <stdio.h>
#include <openssl/des.h>

int main() {
    const_DES_cblock key_data = {0x01, 0x23, 0x45, 0x67, 0x89, 0xAB, 0xCD, 0xEF};
    const_DES_cblock data_to_encrypt = {0xFE, 0xDC, 0xBA, 0x98, 0x76, 0x54, 0x32, 0x10};

    DES_key_schedule ks;
    DES_set_key((const_DES_cblock *)&key_data, &ks);

    DES_cblock encrypted_data;
    DES_ecb_encrypt((const_DES_cblock *)&data_to_encrypt, &encrypted_data, &ks, DES_ENCRYPT);

    printf("Encrypted data: ");
    for (int i = 0; i < 8; i++) {
        printf("%02x ", encrypted_data[i]);
    }
    printf("\n");

    return 0;
}