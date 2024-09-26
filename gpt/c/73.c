
// Volatile is used to tell the compiler not to optimize out the function
static void secure_zero_memory(volatile void *v, size_t n) {
    volatile unsigned char *p = v;
    while (n--) {
        *p++ = 0;
    }
}

