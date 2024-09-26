#include <stdio.h>
#include <stdint.h>
#include <string.h>

struct key {
    uint64_t key[8];
    uint32_t round_keys[16];
};

void key_to_round_keys(struct key *key) {
    for (int i = 0; i < 8; ++i){
        memcpy(&key->round_keys[2*i], &key->key[i], sizeof(uint32_t));
        memcpy(&key->round_keys[(2*i)+1], ((char*)&key->key[i]) + 4, sizeof(uint32_t));
    }
}

int main() {
    struct key k;
    // Initialize k.key with some values
    for (int i = 0; i < 8; ++i) {
        k.key[i] = i;
    }

    key_to_round_keys(&k);

    // Print round keys
    for (int i = 0; i < 16; ++i) {
        printf("%u ", k.round_keys[i]);
    }

    return 0;
}