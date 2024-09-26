#include <openssl/evp.h>
#include <openssl/objects.h>

int main() {
    OpenSSL_add_all_algorithms();
    OpenSSL_add_all_ciphers();
    OpenSSL_add_all_digests();
    return 0;
}