#include <stdio.h>

int main() {
    int c;
    while ((c = getchar()) != EOF && c != '\n') ;  /* discard till end of line or EOF */
    return 0;
}