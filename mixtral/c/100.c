#include <stdio.h>

static const char *hex_chars = "0123456789abcdef";

void print_byte(unsigned char byte) {
    putchar(hex_chars[(byte >> 4) & 0xf]);
    putchar(hex_chars[byte & 0xf]);
}

int main() {
    unsigned char byte = 0x12;
    print_byte(byte);
    return 0;
}