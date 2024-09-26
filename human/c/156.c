#include <stdio.h>

int main() {
    char str[] = "12345\n";
    char str2[] = "12345";

    printf("Hex dump of echo 12345:\n");
    for (int i = 0; i < sizeof(str); i++) {
        printf("%02x ", str[i]);
    }
    printf("\n");

    printf("Hex dump of printf 12345:\n");
    for (int i = 0; i < sizeof(str2); i++) {
        printf("%02x ", str2[i]);
    }
    printf("\n");

    return 0;
}