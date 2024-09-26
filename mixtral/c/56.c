#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char *input = "Hello, World!";
    int pad_len = 16 - (strlen(input) % 16);
    unsigned char *padded_data = malloc((size_t)(strlen(input)+pad_len));
    memcpy(padded_data, input, strlen(input));
    memset(&padded_data[strlen(input)], pad_len, (size_t)pad_len);
    free(padded_data);
    return 0;
}