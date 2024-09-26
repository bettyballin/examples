#include <stdio.h>
#include <openssl/des.h>

int main() {
    DES_cblock key_data;
    DES_key_schedule encrypt_schedule;
    DES_key_schedule decrypt_schedule;

    if (DES_set_odd_parity(&key_data) < 0) {
        printf("ERROR: DES Set Odd Parity Error!\n");
        return 1;
    }

    if (DES_set_key_checked(&key_data, &encrypt_schedule) < 0 ||
        DES_set_key_checked(&key_data, &decrypt_schedule) < 0) {
        printf("ERROR: DES Set Key Checked Error!\n");
        return 1;
    }

    return 0;
}