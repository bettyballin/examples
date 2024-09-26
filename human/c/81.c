#include <crypt.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char* key = "my_secret_key";
    char* salt = "$6$my_secret_salt";
    struct crypt_data* data = malloc(sizeof(struct crypt_data));
    data->initialized = 0;

    return 0;
}