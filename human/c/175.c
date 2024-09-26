#include <stdio.h>
#include <string.h>

typedef unsigned int u_int32_t;

typedef struct {
    u_int32_t key[32];
    u_int32_t round_keys[32];
} Key;

int main() {
    Key key;
    memcpy(&key.round_keys[28], &key.key[28], sizeof(u_int32_t));
    return 0;
}