
#include <stdio.h>
#include <string.h>

void function(char *str) {
    char buffer[16];
    strcpy(buffer, str); // This does not check the length of str before copying
}

int main() {
    char large_string[256];
    memset(large_string, 'A', 255); // Fill the string with 'A' characters
    large_string[255] = '\0';       // Null-terminate the string

    function(large_string); // This will cause a buffer overflow

    return 0;
}

