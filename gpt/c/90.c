
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char* vigenere_encrypt(const char* key, const char* text) {
    if (key == NULL || text == NULL) {
        return NULL;
    }

    size_t text_len = strlen(text);
    size_t key_len = strlen(key);
    char* enc = (char*)malloc(text_len + 1);

    if (!enc) {
        return NULL; // Allocation check
    }

    int key_index = 0;
    for (size_t i = 0; i < text_len; ++i) {
        if (isalpha(text[i])) { // Check if it's a letter
            char key_char = tolower(key
