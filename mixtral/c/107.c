#include <ctype.h>

char cipher_decrypt(char charac, int key) {
    if (islower(charac)) {
        return 'a' + ((26 - (-key % 26)) + (charac - 'a')) % 26;
    } else if (isupper(charac)) {
        return 'A' + ((26 - (-key % 26)) + (charac - 'A')) % 26;
    }
    return charac;
}

int main() {
    char c = 'K';
    int key = 3;
    printf("%c\n", cipher_decrypt(c, key));
    return 0;
}