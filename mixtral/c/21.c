#include <stdio.h>
#include <string.h>

int main() {
    unsigned char result[] = {0x12, 0x34, 0x56, 0x78};
    int len = sizeof(result);

    char resBuffer[1024];
    strcpy(resBuffer, "Sign: ");

    for (int i = 0; i < len; ++i) {
        sprintf(&resBuffer[strlen(resBuffer)], "%02x", result[i]);
    }

    printf("%s\n", resBuffer);

    return 0;
}