#include <stdio.h>
#include <string.h>

void encrypt(char *data, size_t len)
{
    while (len--) {
        *data++ ^= 0xFF;
    }
}

int main() {
    char message[] = "Hello, World!";
    size_t len = strlen(message);
    printf("Original message: %s\n", message);
    encrypt(message, len);
    printf("Encrypted message: %s\n", message);
    encrypt(message, len);
    printf("Decrypted message: %s\n", message);
    return 0;
}