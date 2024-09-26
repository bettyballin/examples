#include <stdio.h>
#include <string.h>
#include <crypt.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <hash>\n", argv[0]);
        return 1;
    }

    const char *salt = "your_salt"; // replace with your salt
    struct crypt_data data;
    data.initialized = 0;

    for (int i = 0; i < 10000; i++) { // assuming 4-digit PIN
        char key[5];
        sprintf(key, "%04d", i);
        char *hash = crypt_r(key, salt, &data);
        if (strcmp(hash, argv[1]) == 0) {
            printf("PIN found: %s\n", key);
            return 0;
        }
    }

    printf("PIN not found\n");
    return 1;
}