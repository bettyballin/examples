
#include <openssl/des.h>

byte_array_ptr triple_des_encrypt_to_pin_block(byte_array_ptr key_bytes, byte_array_ptr xor_bytes) {
    if (key_bytes->size != 24 || xor_bytes->size != 8)
        return NULL;

    DES_key_schedule schedule1, schedule2, schedule3;
    DES_cblock key1
