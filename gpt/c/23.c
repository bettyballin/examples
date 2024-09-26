
#include <string.h>

void xor_encrypt(char *message, const char *key) {
    size_t msg_len = strlen(message);
    size_t key_len = strlen(key);
    
    for (size_t i = 0; i < msg_len; ++i) {
        message[i] ^= key[i % key_len]; // XOR current character with key character
    }
}

