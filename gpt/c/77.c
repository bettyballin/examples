pp
bool isValidAddition(unsigned short x, unsigned short y) {
    // USHRT_MAX is the maximum value for an unsigned short.
    // It's defined in the <climits> or <limits.h> header file.
    if (USHRT_MAX - x >= y)
        return
