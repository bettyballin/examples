#include <openssl/ec.h>
#include <openssl/bn.h>
#include <stdio.h>

int main() {
    EC_GROUP *curve;
    EC_KEY *key;
    EC_POINT *pub;
    BIGNUM *priv;
    BN_CTX *ctx;

    // Initialize OpenSSL
    OpenSSL_add_all_algorithms();

    // Generate a new EC curve
    curve = EC_GROUP_new_by_curve_name(NID_secp256k1);

    // Generate a new EC key
    key = EC_KEY_new();

    // Generate a new BN context
    ctx = BN_CTX_new();

    // Generate a new private key
    priv = BN_new();
    BN_rand_range(priv, EC_GROUP_get0_order(curve));

    // Generate a new public key
    pub = EC_POINT_new(curve);
    if (!EC_POINT_mul(curve, pub, priv, NULL, NULL, ctx)) {
        printf("Failed to generate public key\n");
        return 1;
    }

    // Set private key for the private key object
    if (1 != EC_KEY_set_private_key(key, priv)) {
        printf("Failed to set private key for the private key object\n");
        return 1;
    }

    // Set public key for the public key object
    if (!EC_POINT_copy(EC_GROUP_get0_generator(curve), pub) ||
        1 != EC_KEY_set_public_key(key, pub)) {
        printf("Failed to set public key for the public key object\n");
        return 1;
    }

    // Free resources
    EC_GROUP_free(curve);
    EC_KEY_free(key);
    EC_POINT_free(pub);
    BN_free(priv);
    BN_CTX_free(ctx);

    return 0;
}