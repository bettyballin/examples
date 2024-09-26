cpp
#include <stdio.h>
#include <sys/types.h>
#include <string.h>
#include <tomcrypt.h>

#define STR "Hola guasssso c|mo estais ...012"

void print_hash(const u_int8_t *hash) {
    printf("%08x %08x %08x %08x\n",
           *(u_int32_t*)(&hash[0]),
           *(u_int32_t*)(&hash[4]),
           *(u_int32_t*)(&hash[8]),
           *(u_int32_t*)(&hash[12]));
}

int main(int argc, char *argv[]) {
    uint8_t key[16] = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 
                        0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f  };
    uint8_t hash[16];
    int idx, err;
    unsigned char str[3] = {0x00, 0x01, 0x02};
    unsigned long taglen = 16;

    register_all_ciphers();
    register_all_hashes();
    register_all_prngs();

    if ((idx = find_cipher("aes")) == -1) {
        if ((idx = find_cipher("rijndael")) == -1) {
            printf("idx:%d\n", idx);
            return CRYPT_NOP;
        }
    }
    if ((err = xcbc_memory(idx, key, 16, str, 3, hash, &taglen)) != CRYPT_OK) {
        printf("err:%d\n", err);
        return err;
    }

    print_hash(hash);
    str[2] = 'x';
    if ((err = xcbc_memory(idx, key, 16, str, 3, hash, &taglen)) != CRYPT_OK) {
        printf("err:%d\n", err);
        return err;
    }
    print_hash(hash);
    return 0;
}