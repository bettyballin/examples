#include <string.h>
#include <stdio.h>

int main() {
    unsigned char key[32];
    memcpy(key, "my_secret_key", 16);
    return 0;
}