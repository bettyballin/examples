#include <stdio.h>
#include <stdint.h>

struct key {
    uint64_t key[4];
    uint32_t round_keys[8];
};

void key_to_round_keys(struct key *key)
{
    for (int n = 0; n < 4; n++)
    {
        key->round_keys[2*n] = key->key[n] >> 32;
        key->round_keys[2*n+1] = key->key[n] & 0xFFFFFFFFu;
    }
};

int main() {
    struct key my_key = {{0x1234567890abcdef, 0x234567890abcdef1, 0x34567890abcdef12, 0x4567890abcdef123}};
    key_to_round_keys(&my_key);
    for (int i = 0; i < 8; i++) {
        printf("%08x ", my_key.round_keys[i]);
    }
    printf("\n");
    return 0;
}