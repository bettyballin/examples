#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/hmac.h>

static int my_hmac(unsigned char *data, int len, char *password, unsigned char *hmac)
{
    unsigned char* digest;
    digest = HMAC(EVP_sha1(), password, strlen(password), data, len, NULL, NULL);
    memcpy(hmac, digest, 20);
    return 0;
}

int main(int argc, char **argv) {
    unsigned char buf[20];
    char *txt = "kallel";   
    my_hmac((unsigned char*)txt, strlen(txt), "password", buf);
    for (int i = 0; i < 20; i++) {
        printf("%02x", buf[i]);
    }
    printf("\n");
    return 0;
}