#include <stdio.h>
#include <string.h>

int main() {
    char resBuffer[1024];
    char header1[] = "Sign: ";
    char result[] = "your_result_string_here";
    int len = strlen(result);

    strcpy(resBuffer, header1);

    for (int i = 0; i < len / 2; ++i) {
        sprintf(&resBuffer[strlen(header1) + i * 3], "%02x", result[i]);
    }

    printf("%s\n", resBuffer);

    return 0;
}