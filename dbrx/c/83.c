#include <stdio.h>
#include <string.h>
#include <openssl/hmac.h>
#include <stdlib.h>

unsigned char *mx_hmac_sha256(const void *key, int keylen, const unsigned char *data, int datalen, unsigned char *result) {
    return HMAC(EVP_sha256(), key, keylen, data, datalen, result, NULL);
}

int main() {
    char *key = strdup("security is awesome");
    int keylen = strlen(key);
    const unsigned char *data = (const unsigned char *)strdup("this is highly sensitive user data");
    int datalen = strlen((char *)data);

    // Allocate enough space for the result
    unsigned char result[32];
    mx_hmac_sha256((const void *)key, keylen, data, datalen, result);

    printf("HMAC-SHA256: ");
    for (int i = 0; i < sizeof(result); ++i) {
        // Print hexadecimal representation of each byte
        printf("%02x", result[i]);
    }
    printf("\n");

    free(key);
    free((void *)data);

    return 0;
}