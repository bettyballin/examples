#include <openssl/bn.h>

int main() {
    BN_CTX *ctx = BN_CTX_new();
    BIGNUM *bn1 = BN_new();
    BIGNUM *bn2 = BN_new();
    BIGNUM *r = BN_new();
    BIGNUM *result = BN_new();

    // ... (initialize bn1, bn2, r)

    if (!BN_mod_exp(result, bn2, bn1, r, ctx)) {
        // Handle error
    }

    BN_CTX_free(ctx);
    BN_free(bn1);
    BN_free(bn2);
    BN_free(r);
    BN_free(result);

    return 0;
}