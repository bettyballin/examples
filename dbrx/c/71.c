#include <openssl/err.h>
#include <openssl/evp.h>

int main() {
    OpenSSL_add_all_algorithms();
    ERR_load_crypto_strings();
    return 0;
}