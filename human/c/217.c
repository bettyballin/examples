#include <stdio.h>

int main(void) {
    char line[30];
    fgets(line, sizeof(line), stdin);
    for (int i = 0; i < sizeof(line); ++i) {
        printf("%d: %X\n", i, line[i]);
    }
    return 0;
}