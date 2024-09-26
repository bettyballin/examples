cpp
#include <iostream>
#include <cstdint>

uint32_t hash_value(uint32_t v) {
    return v; // Replace with your actual hash function
}

int main() {
    uint32_t seed = 0; // Initialize seed
    uint32_t v = 1; // Value to be hashed
    seed ^= hash_value(v) + 0x9e3779b9 + (seed << 6) + (seed >> 2);
    return 0;
}