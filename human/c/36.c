#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 256

int main() {
    char key[MAX];
    printf("* Type the encoding key (numbers only): ");
    fgets(key, MAX, stdin);
    key[strcspn(key, "\n")] = 0;

    char* encoded_text = "BDFBDF";
    printf("* Encoded text is: %s\n", encoded_text);

    return 0;
}