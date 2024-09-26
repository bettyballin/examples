#include <stdio.h>

char decrypt(char c, char r[]) {
    for (int num = 0; num < 26; ++num) {
        if (r[num] == c) {
            return ((char)(65 + num));
        }
    }
    return (c); // Should never get here
}

int main() {
    char r[26] = "abcdefghijklmnopqrstuvwxyz";
    char c = 'd';
    printf("%c\n", decrypt(c, r));
    return 0;
}