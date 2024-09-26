
#include <stdint.h>

uint8_t propagate_msb_to_all(uint8_t value) {
    // Shift the MSB to the least significant bit position, then multiply by 0xFF.
    // Shifting by 7 is constant time as it's a fixed amount, and multiplication
    // by 0xFF is also constant time.
    return (-(value >> 7)) & 0xFF;
}

int main() {
    uint8_t value = 0x80; // Example value with MSB set
    uint8_t result = propagate_msb_to_all(value);
    // result should now be 0xFF
}

