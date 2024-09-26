#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <time.h>

#define NUM_BITS 256

void base64_encode(const uint8_t* data, size_t len, char** out) {
    static const char* b64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    size_t out_len = (len + 2) / 3 * 4 + 1;
    *out = (char*)malloc(out_len * sizeof(char));

    size_t i, j;
    for (i = 0, j = 0; i < len; i += 3) {
        uint32_t val = (data[i] << 16) + (i + 1 < len ? data[i + 1] << 8 : 0) + (i + 2 < len ? data[i + 2] : 0);
        (*out)[j++] = b64[(val >> 18) & 0x3F];
        (*out)[j++] = b64[(val >> 12) & 0x3F];
        (*out)[j++] = (i + 1 < len) ? b64[(val >> 6) & 0x3F] : '=';
        (*out)[j++] = (i + 2 < len) ? b64[val & 0x3F] : '=';
    }
    (*out)[j] = '\0';
}

void create_random_iv(uint8_t** iv, size_t len) {
    *iv = (uint8_t*)malloc(len * sizeof(uint8_t));

    FILE* urandom = fopen("/dev/urandom", "r");
    fread(*iv, 1, len, urandom);
    fclose(urandom);
}

int main() {
    size_t iv_len = NUM_BITS / 8;
    uint8_t* random_iv;
    create_random_iv(&random_iv, iv_len);

    char* printable_key;
    base64_encode(random_iv, iv_len, &printable_key);

    printf("%s\n", printable_key);

    free(random_iv);
    free(printable_key);

    return 0;
}