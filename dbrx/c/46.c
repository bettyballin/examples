#include <stdio.h>
#include <stdbool.h>

#define KEY_SIZE 16

void crypt_buffer(unsigned char *buffer, size_t size, const unsigned char* key, bool is_encrypt) {
    int j = 0;
    if (is_encrypt)
        for(size_t i = 0; i < size; ++i) {
            buffer[i] ^= key[j];
            j++;
            if(j >= KEY_SIZE)
                j = 0;
        }
    else
        // Reverse the XOR operation by using the same `key` and applying it again.
        crypt_buffer(buffer, size, key, true);
}

int main() {
    unsigned char buffer[] = "Hello, World!";
    unsigned char key[KEY_SIZE] = "my_secret_key";
    size_t size = sizeof(buffer) - 1; // exclude null terminator

    printf("Original: %s\n", buffer);

    crypt_buffer(buffer, size, key, true);
    printf("Encrypted: %s\n", buffer);

    crypt_buffer(buffer, size, key, false);
    printf("Decrypted: %s\n", buffer);

    return 0;
}