#include <string.h>
#include <gnutls/gnutls.h>

#define KEY_LENGTH 32

int main() {
    unsigned char key[KEY_LENGTH];
    memset(key, 0x12, KEY_LENGTH);

    const gnutls_datum_t k = { .data = (void*)key, .size = KEY_LENGTH };

    unsigned char iv[KEY_LENGTH];
    memset(iv, 0x34, KEY_LENGTH);

    const gnutls_datum_t iv_datum = { .data = (void*)iv, .size = KEY_LENGTH };

    return 0;
}