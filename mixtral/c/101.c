#include <stdio.h>

void print_byte(unsigned char byte) {
    printf("%02x", byte);
}

int main() {
    unsigned char result[] = {0x12, 0x34, 0x56, 0x78};
    unsigned int resultlen = sizeof(result);

    for (unsigned int i = 0; i < resultlen; ++i) {
        print_byte(result[i]);
        putchar(' ');
    }
    puts("");

    return 0;
}