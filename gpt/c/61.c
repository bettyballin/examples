
int secure_memcmp(const void *a, const void *b, size_t size) {
    const volatile unsigned char *pa = a;
    const volatile unsigned char *pb = b;
    volatile unsigned char result = 0;

    for (size_t i = 0; i < size; i++) {
        result |= pa[i] ^ pb[i];
    }

    /* Cast to unsigned char to ensure that the value is between 0 and 255,
       then subtract 0 to convert to either 0 or 1 */
    return (unsigned char)(result != 0) - 0;
}

