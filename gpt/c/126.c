
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <openssl/hmac.h>

unsigned char *mx_hmac_sha256(const void *key, int keylen,
                              const unsigned char *data, int datalen,
                              unsigned char *result, unsigned int *resultlen) {
    return HMAC(EVP_sha256(), key, keylen, data, datalen, result, resultlen);
}

int main() {
    char *key = "security is awesome"; // No need to strdup, just use the string literal
    int keylen = strlen(key);
    const unsigned char *data = (const unsigned char *)"this is
