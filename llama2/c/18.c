#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define TRIPLE_DES_KEY_SIZE 24

typedef struct {
    unsigned char k[3][8];
} triple_des_key;

triple_des_key generate_triple_des_key(const char *password) {
    triple_des_key key;

    // Seed the random number generator
    srand(time(NULL));

    // Generate three random keys
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 8; j++) {
            key.k[i][j] = (unsigned char)(rand() & 0xFF);
        }
    }

    return key;
}

int main() {
    const char *password = "my_password";
    triple_des_key key = generate_triple_des_key(password);

    // Print the generated key
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 8; j++) {
            printf("%02X", key.k[i][j]);
        }
        printf("\n");
    }

    return 0;
}