#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {
    char key[10];
    printf("* Type the encoding key (numbers only): ");
    fgets(key, sizeof(key), stdin);
    key[strcspn(key, "\n")] = 0;

    for (int i = 0; i < strlen(key); i++) {
        if (!isdigit(key[i])) {
            printf("Invalid input. Please enter numbers only.\n");
            return 1;
        }
    }

    printf("* Encoded text is: ");
    for (int i = 0; i < strlen(key); i++) {
        char c = 'A' + atoi(&key[i]) - 1;
        printf("%c", c);
    }
    printf("\n");

    return 0;
}