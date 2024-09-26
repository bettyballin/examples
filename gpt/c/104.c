
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>

int main(void) {
    char contentLengthValue[64];
    size_t len = 0;
    errno_t err;

    // Get the CONTENT_LENGTH safely
    err = getenv_s(&len, contentLengthValue, sizeof(contentLengthValue), "CONTENT_LENGTH");
    if (err || len == 0) {
        printf("Error getting CONTENT_LENGTH or it's not set\n");
        return 1
