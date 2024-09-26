#include <stdio.h>
#include <string.h>

int main() {
    const char *header1 = "Sign: ";
    size_t PrefixL = strlen(header1);
    unsigned char result[] = {0x12, 0x34, 0x56, 0x78}; // example data
    size_t len = sizeof(result);

    char resBuffer[PrefixL + 2*len + 1];
    strcpy(resBuffer, header1);
    char *p = &resBuffer[PrefixL];

    for(unsigned int i = 0; i < len; i++)  
    {
        sprintf(p, "%02X", (unsigned int) result[i]);
        p += 2;  
    }
    printf("%s\n", resBuffer);

    return 0;
}