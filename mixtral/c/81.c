#include <openssl/bn.h>
#include <openssl/rand.h>

int main() {
    BIGNUM *bn = BN_new();
    if (!bn) {
        return 1;
    }

    if (BN_rand(bn, 128, 0, 0) != 1) {
        BN_free(bn);
        return 1;
    }

    BN_free(bn);
    return 0;
}