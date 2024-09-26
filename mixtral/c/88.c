#include <stdio.h>
#include <string.h>
#include <crypt.h>
#include <stdbool.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <hash>\n", argv[0]);
        return 1;
    }

    const char *hash = argv[1];
    const char *salt = "50";
    const char *key[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r"};

    if (strlen(argv[1]) == 1) {
        bool found = false;

        for (int i = 0; i < 18 && !found; i++) {
            char *cipher = crypt(key[i], salt);

            int comp = strcmp(cipher, hash);

            if (comp == 0) {
                printf("%s\n", key[i]);

                found = true;
            }
        }

        if (!found) {
            printf("Unmatched\n");
        }
    }

    return 0;
}