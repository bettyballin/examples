#include <stdio.h>

char decrypt(char c, char r[]) {
    int num = (int)c - 65;
    return r[num];
}

int main() {
    char c = 'A';
    char r[] = "abcdefghijklmnopqrstuvwxyz";
    printf("%c\n", decrypt(c, r));
    return 0;
}