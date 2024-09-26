#include <stdio.h>
#include <string.h>

int main() {
    char buffer[16];
    char temp[1024];
    fgets(temp, 1024, stdin);
    temp[strcspn(temp, "\n")] = 0; // remove newline character
    if (strlen(temp) > 15) { // changed to 15 to account for null terminator
        printf("Error: Input too long\n");
        return 1;
    }
    strcpy(buffer, temp); // safe
    return 0;
}