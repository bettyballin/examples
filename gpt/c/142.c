
#include <stdio.h>
#include <gmp.h>
#include <string.h>

int char_index(char c) {
    const char *base58_chars = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    char *ptr = strchr(base58_chars, c);
    return
