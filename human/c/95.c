#include <stdio.h>
#include <stdint.h>

#define BF_N 16
#define BF_word_signed int32_t

typedef struct {
    uint32_t P[BF_N + 2];
} BF_init_state;

int main() {
    uint32_t tmp[2];
    uint32_t diff = 0;
    uint32_t sign = 0;
    uint8_t *ptr = NULL;
    uint8_t *key = NULL;
    uint32_t expanded[BF_N + 2];
    uint32_t initial[BF_N + 2];
    BF_init_state BF_init_state;
    int bug = 0; // assuming bug is 0, change to 1 to test the "bug" line

    for (int i = 0; i < BF_N + 2; i++) {
        tmp[0] = tmp[1] = 0;
        for (int j = 0; j < 4; j++) {
            tmp[0] <<= 8;
            tmp[0] |= (unsigned char)*ptr; /* correct */
            tmp[1] <<= 8;
            tmp[1] |= (BF_word_signed)(signed char)*ptr; /* bug */

            if (j)
                sign |= tmp[1] & 0x80;
            if (!*ptr)
                ptr = key;
            else
                ptr++;
        }
        diff |= tmp[0] ^ tmp[1]; /* Non-zero on any differences */

        expanded[i] = tmp[bug];
        initial[i] = BF_init_state.P[i] ^ tmp[bug];
    }

    return 0;
}