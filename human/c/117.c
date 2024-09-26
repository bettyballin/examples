#include <stdio.h>
#include <string.h>

#define MAXSIZE 100

char *decryption(char Ciphered[MAXSIZE], int A, int B, int inverse) {
    static char NewPlaintext[MAXSIZE];
    char x;
    char index;
    for (int i = 0; i < strlen(Ciphered); i++) {
        if (Ciphered[i] == ' ') {
            NewPlaintext[i] = ' ';
        } else {
            index = (int)Ciphered[i] - 'a';
            x = inverse * (index - B) % 26;
            if (x < 0) {
                x += 26;
            }
            NewPlaintext[i] = (char)x + 97;
        }
    }
    NewPlaintext[strlen(Ciphered)] = '\0';
    return NewPlaintext;
}

int main() {
    char ciphered[MAXSIZE] = "your_ciphered_text";
    int A = 1, B = 2, inverse = 3;
    char *plaintext = decryption(ciphered, A, B, inverse);
    printf("%s\n", plaintext);
    return 0;
}