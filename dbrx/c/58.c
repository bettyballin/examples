#include <openssl/ec.h>
#include <openssl/bn.h>
#include <stdio.h>
#include <openssl/obj_mac.h>

int main() {
    EC_KEY *eckey = NULL;
    const BIGNUM *res;

    eckey = EC_KEY_new_by_curve_name(NID_X9_62_prime256v1);
    if (EC_KEY_generate_key(eckey) == 0)
        return -1; // error handling

    res = EC_KEY_get0_private_key(eckey);
    printf("Private: %s\n", BN_bn2hex(res));

    unsigned char pub[65];
    size_t len = sizeof(pub);

    if (EC_POINT_point2oct(EC_KEY_get0_group(eckey), EC_KEY_get0_public_key(eckey), POINT_CONVERSION_UNCOMPRESSED, pub, len, NULL) == 0)
        return -1; // error handling

    printf("Public: %s\n", BN_bn2hex(BN_bin2bn(pub + 1, 32, NULL)));

    unsigned char pub_compressed[33];
    if (EC_POINT_point2oct(EC_KEY_get0_group(eckey), EC_KEY_get0_public_key(eckey), POINT_CONVERSION_COMPRESSED, pub_compressed, sizeof(pub_compressed), NULL) == 0)
        return -1; // error handling

    printf("Public compressed: %s\n", BN_bn2hex(BN_bin2bn(pub_compressed + 1, 32, NULL)));

    EC_KEY_free(eckey);
    return 0;
}