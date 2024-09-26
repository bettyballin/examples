#include <stdio.h>

int main() {
    char charac = 'a';
    int cle = 3;

    charac = 'a' + (((charac - 'a' + cle) % 26) + 26) % 26;

    printf("%c\n", charac);

    return 0;
}