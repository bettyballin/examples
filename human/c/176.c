#include <stdint.h>

struct key {
    uint64_t key[4];
    uint32_t round_keys[8];
};

void key_to_round_keys(struct key *key)
{
    key->round_keys[0] = key->key[0] >> 32;
    key->round_keys[1] = key->key[0] & 0xFFFFFFFFu;
    key->round_keys[2] = key->key[1] >> 32;
    key->round_keys[3] = key->key[1] & 0xFFFFFFFFu;
    key->round_keys[4] = key->key[2] >> 32;
    key->round_keys[5] = key->key[2] & 0xFFFFFFFFu;
    key->round_keys[6] = key->key[3] >> 32;
    key->round_keys[7] = key->key[3] & 0xFFFFFFFFu;
}

int main() {
    struct key my_key;
    my_key.key[0] = 0x1234567890abcdef;
    my_key.key[1] = 0xfedcba9876543210;
    my_key.key[2] = 0x1111111111111111;
    my_key.key[3] = 0x2222222222222222;
    
    key_to_round_keys(&my_key);
    
    for (int i = 0; i < 8; i++) {
        printf("%x\n", my_key.round_keys[i]);
    }
    
    return 0;
}