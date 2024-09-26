#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void OPENSSL_cleanse(void *ptr, size_t len) {
    unsigned char *p = ptr;
    size_t i;
    for (i = 0; i < len; i++) {
        p[i] = rand() % 256;
    }
}

int main() {
    char buff[256];
    char buf[256];
    char key[256] = "password";
    int bufsiz = 256;
    int SIZE = 256;
    char str[256] = "Hello, World!";
    
    OPENSSL_cleanse(buff, (unsigned int)bufsiz);
    OPENSSL_cleanse(buf, (unsigned int)bufsiz);
    OPENSSL_cleanse(buf, (unsigned int)bufsiz);
    OPENSSL_cleanse(key, strlen(key));
    OPENSSL_cleanse(buf, 256);
    OPENSSL_cleanse(str, SIZE);
    OPENSSL_cleanse(str, strlen(str));

    return 0;
}