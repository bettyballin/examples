#include <openssl/err.h>
#include <openssl/evp.h>
#include <openssl/rand.h>

int main() {
    OpenSSL_add_all_algorithms();
    ERR_load_BIO_strings();
    RAND_poll();
    return 0;
}