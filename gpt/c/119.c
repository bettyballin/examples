
void key_to_round_keys(struct key *key) {
    for (int i = 0; i < 4; i++) {
        // Take the higher 32 bits by shifting right 32 bits
        key->round_keys[i * 2] = key->key[i] >> 32;
        // Take the lower 32 bits by masking out the higher 32 bits
        key->round_keys
