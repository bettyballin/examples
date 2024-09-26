#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* vigenere_encrypt(const char *key, const char *text) {
    if (key == NULL || text == NULL)
        return NULL;

    int i = 0, j = 0, klen = strlen(key), tlen = strlen(text);

    // Allocate memory for encrypted string
    char* result = malloc((tlen + 1)*sizeof(*result));

    if (result == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }

    for (i = 0; i < tlen; i++) {
        char c = text[i];
        if (c >= 'a' && c <= 'z') {
            int shift = (key[j % klen] - 'a');
            c = 'a' + (c - 'a' + shift) % 26;
            j++;
        } else if (c >= 'A' && c <= 'Z') {
            int shift = (key[j % klen] - 'a');
            c = 'A' + (c - 'A' + shift) % 26;
            j++;
        }
        result[i] = c;
    }

    result[tlen] = '\0';
    return result;
}

int main() {
    const char *key = "test";
    const char *text = "Hello, World!";
    char *encrypted = vigenere_encrypt(key, text);
    if (encrypted != NULL) {
        printf("Encrypted text: %s\n", encrypted);
        free(encrypted);
    }
    return 0;
}