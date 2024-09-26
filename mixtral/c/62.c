#include <stdio.h>

int main() {
    int B = 1;  // replace with your value
    int inverse = 1;  // replace with your value
    int index = 1;  // replace with your value
    char NewPlaintext[2];

    int x = ((inverse * (index - B) % 26 + 26) % 26);
    NewPlaintext[0] = (char)(x + 'a');
    NewPlaintext[1] = '\0';

    printf("%s\n", NewPlaintext);

    return 0;
}