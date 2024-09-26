
uint8_t constant_time_shift_left(uint8_t value, uint8_t shift) {
    // Precomputed table for all possible shifts of a single byte
    uint8_t shifts[8][256]; // 8 possible shifts for each of the 256 byte values
    for (int s = 0; s < 8; ++s) {
        for (int v = 0; v < 256; ++v) {
            shifts[s][v] = (uint8_t)(v << s);
        }
    }

    // Constant-time selection of the result
    uint8_t result = 0;
    for (int i = 0; i < 8; ++i) {
        uint8_t mask = (uint8_t)(-(i == shift)); // Mask is all bits set if
