#include <stdio.h>
#include <string.h>

void encrypt(int rail, char *plain) {
    char railfence[rail][strlen(plain)];
    int i, j, k = 0;
    int column_count = 0;

    for (i = 0; i < rail; i++)
        strcpy(railfence[i], "");

    for (i = 0; i < strlen(plain); i++) {
        if (k == 0)
            j = 0;
        if (k == rail - 1)
            j = -1;

        strcat(railfence[k], (char[2]) { plain[i], '\0' });
        k += j;
    }

    for (i = 0; i < rail; ++i) {
        printf("%s", railfence[i]);

        if ((column_count += strlen(railfence[i])) >= 80) {
            column_count = 0;
            putchar('\n');
        }
    }
}

int main() {
    char plain_text[] = "This is a sample text to encrypt";
    int rail = 3;
    encrypt(rail, plain_text);
    return 0;
}