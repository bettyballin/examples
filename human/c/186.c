#include <stdio.h>
#include <string.h>

int main() {
    unsigned int addr = 0x41414141;
    char buf[20];

    printf("%#x\n", addr);
    sprintf(buf, "AAAA %x %x %x %x %x %x %x %x");
    printf("%s\n", buf);
    printf("AAAA %x %x %x %x %x %x %x %x\n", 
           0xc8, 0xf7ef9540, 0x5661521a, 0, 0, addr, 0x20782520, 0x25207825);

    return 0;
}