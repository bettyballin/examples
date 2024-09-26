
uint8_t SecureClear(volatile uint8_t *dest, uint8_t val, size_t len) {
    if (dest == NULL) {
        return 0; // Error, invalid destination
    }

    for (size_t i = 0; i < len; ++i) {
        dest[i] = val;   // Set each byte individually
    }

    // Verify that the memory was set correctly
    for (size_t i = 0; i < len; ++i) {
        if (dest[i] != val) {
            return 0; // Error, verification failed
        }
    }

    return 1; // Success
}

uint8_t Delete()
{
    if (SecureClear((volatile uint8_t*)cure.name, 0x0, 32) &&
        SecureClear((volatile uint8_t*)&
