#include <stdio.h>
#include <string.h>
#include <blake2.h>

int main(){
    char *test_data = "Hello World!";

    unsigned char hash[32];

    size_t len = strlen(test_data);

    unsigned char str[len + 1];

    memcpy(str, test_data, len+1);

    int a = blake2s(hash, str, NULL, sizeof(hash), len, 0);

    for(int i = 0; i < 32; i++)
        printf("%02x", hash[i]);

    return 0;
}