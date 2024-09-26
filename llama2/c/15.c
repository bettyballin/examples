#include <stdio.h>

int main() {
    char firstName[10];
    scanf("%9s", firstName); // 9 is the maximum number of characters that fit in firstName
    printf("Hello, %s!\n", firstName);
    return 0;
}