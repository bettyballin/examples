#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define PHP_MAX_SALT_LEN 128

typedef struct _zend_string {
    char *val;
    size_t len;
} zend_string;

zend_string* zend_string_init(const char *str, size_t len, int persistent) {
    zend_string *ret = malloc(sizeof(zend_string));
    ret->val = malloc(len + 1);
    memcpy(ret->val, str, len);
    ret->val[len] = '\0';
    ret->len = len;
    return ret;
}

void ZEND_SECURE_ZERO(void *p, size_t len) {
    volatile char *v = (volatile char *)p;
    while (len--) {
        *v++ = 0;
    }
}

char* php_crypt_blowfish_rn(const char *password, const char *salt, char *output, int size) {
    // implement blowfish encryption here
    // for now, just return a dummy string
    strncpy(output, "blowfish-encrypted-string", size);
    return output;
}

int main() {
    char password[] = "mysecretpassword";
    char salt[] = "$2a$12$34";

    if (salt[0] == '$' &&
        salt[1] == '2' &&
        salt[3] == '$') {
        char output[PHP_MAX_SALT_LEN + 1];

        memset(output, 0, PHP_MAX_SALT_LEN + 1);

        char* crypt_res = php_crypt_blowfish_rn(password, salt, output, sizeof(output));
        if (!crypt_res) {
            ZEND_SECURE_ZERO(output, PHP_MAX_SALT_LEN + 1);
            return 1;
        } else {
            zend_string* result = zend_string_init(output, strlen(output), 0);
            ZEND_SECURE_ZERO(output, PHP_MAX_SALT_LEN + 1);
            printf("%s\n", result->val);
            free(result->val);
            free(result);
        }
    }
    return 0;
}