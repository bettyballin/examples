#include <stdio.h>

int main() {
    unsigned char outbuf[] = {0x12, 0x34, 0x56, 0x78};
    int outlen = sizeof(outbuf);

    for (int i = 0; i < outlen; ++i) {
        printf("%.2x", outbuf[i]);
    }

    return 0;
}