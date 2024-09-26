#include <openssl/ec.h>
#include <openssl/bn.h>
#include <stdio.h>
#include <stdint.h>

typedef struct {
    uint8_t gx[32];
    uint8_t gy[32];
} sgx_ec256_public_t;

const sgx_ec256_public_t sgx_pk = {
    .gx = {0x82, 0xcb, 0x6f, 0x41, 0x3a, 0xd4, 0xfa, 0x57,
           0x1b, 0x4e, 0x5a, 0x5c, 0x45, 0x14, 0x94, 0xf7,
           0x8b, 0x17, 0x72, 0x71, 0x1a, 0x4d, 0x6e, 0x8a,
           0x3c, 0x12, 0x51, 0x43, 0x8a, 0x6e, 0x23, 0x57},
    .gy = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
           0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
           0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
           0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00}
};

int main() {
    EC_GROUP *group = EC_GROUP_new_by_curve_name(NID_X9_62_prime256v1);
    BN_CTX *bn_ctx = BN_CTX_new();

    BIGNUM *x = BN_bin2bn(sgx_pk.gx, sizeof(sgx_pk.gx), NULL);
    BIGNUM *y = BN_bin2bn(sgx_pk.gy, sizeof(sgx_pk.gy), NULL);

    if (x == NULL || y == NULL) {
        printf("Error extracting affine coordinates\n");
        return -1;
    }

    EC_KEY *ec_key = EC_KEY_new();
    if (EC_KEY_set_group(ec_key, group) != 1 ||
        EC_POINT_set_affine_coordinates_GFp(group, EC_KEY_get0_public_key(ec_key), x, y, bn_ctx) != 1) {
        printf("Error setting affine coordinates\n");
        return -1;
    }

    BN_free(x);
    BN_free(y);
    EC_KEY_free(ec_key);
    BN_CTX_free(bn_ctx);
    EC_GROUP_free(group);

    return 0;
}