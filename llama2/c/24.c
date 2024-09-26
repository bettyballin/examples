#include <openssl/err.h>
#include <openssl/evp.h>

int main() {
    void *msg_hash = OPENSSL_malloc(sizeof(unsigned char) * (EVP_MAX_MD_SIZE + 1));
    if (msg_hash == NULL) {
        ERR_print_errors_fp(stderr);
        return 1;
    }
    // Rest of your code here...
    OPENSSL_free(msg_hash);
    return 0;
}