#include <stdio.h>
#include <string.h>

int main() {
    char str[] = "Hello, World!";
    char buffer[100];
    size_t len = strlen(str);
    if (len >= sizeof(buffer) / sizeof(buffer[0]))  return -1;
    memcpy(buffer, str, len + 1);
    printf("%s\n", buffer);
    return 0;
}