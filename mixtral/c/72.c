#include <stdio.h>
#include <string.h>
#include <openssl/des.h>

void encrypt_cbc(const unsigned char *in, int len,
                 const DES_key_schedule *ks1,
                 const DES_cblock iv[DES_BLOCK_SIZE],
                 unsigned char out[]) {
    register DES_LONG l;

    while (len >= 8) {
        memcpy(out, in, DES_BLOCK_SIZE);

        /* XOR the plaintext with IV */
        for (l = 0L; l < DES_BLOCK_SIZE / sizeof(DES_LONG); l++)
            ((DES_LONG *) out)[l] ^= ((DES_LONG *) iv)[l];

        DES_ecb3_encrypt((const DES_cblock*)out, (const DES_key_schedule*)ks1,
                         (DES_cblock*)(out), DES_ENCRYPT);

        /* Save the last ciphertext block as IV for next iteration */
        memcpy(iv, out + DES_BLOCK_SIZE - DES_BLOCK_SIZE,
               sizeof iv[0] * (DES_BLOCK_SIZE / sizeof(DES_LONG)));

        in += 8;
        len -= 8;
    }
}

int main() {
    const unsigned char *in = (const unsigned char *) "Hello World!";
    int len = strlen((const char *) in);
    DES_key_schedule ks1;
    DES_cblock iv;
    unsigned char out[len];

    DES_set_odd_parity(&iv);
    DES_set_key((const_DES_cblock *) "01234567", &ks1);

    encrypt_cbc(in, len, &ks1, &iv, out);

    for (int i = 0; i < len; i++) {
        printf("%02x", out[i]);
    }
    printf("\n");

    return 0;
}