// poly1305-donna.c
#include <stdint.h>

void poly1305_init(void);
void poly1305_blocks(void *, const unsigned char *, size_t);
void poly1305_finish(void *, const unsigned char *);

// example-poly1305.c
#include <stdio.h>
#include <stdint.h>
#include <string.h>

#include "poly1305-donna.h"

#define POLY1305_16BIT

int main() {
    uint8_t key[32];
    uint8_t msg[1024];
    uint8_t tag[16];

    for (size_t i = 0; i < sizeof(key); i++) {
        key[i] = 0;
    }

    for (size_t i = 0; i < sizeof(msg); i++) {
        msg[i] = 0;
    }

    poly1305_init();
    poly1305_blocks(tag, msg, sizeof(msg));
    poly1305_finish(tag, key);

    uint8_t expected[16] = {0};
    if (memcmp(tag, expected, sizeof(tag)) != 0) {
        printf("poly1305 self test: failed\n");
        return 1;
    }

    printf("poly1305 self test: passed\n");
    return 0;
}