
#include <stdio.h>
#include <stdlib.h>

void concat(char s[], char t[], size_t bufSize);

int main(int argc, char** argv) {
    // Ensure that 'a' is large enough to hold both strings and the null terminator.
    char a[12] = "hello "; // 6 characters + 1 for the null terminator = 7
    char b[] = "world"; // 5 characters + 1 for the null terminator = 6

    // Size of 'a' is 
