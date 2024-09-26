#include <sgx_tcrypto.h>
#include <openssl/ec.h>
#include <openssl/bn.h>
#include <openssl/obj_mac.h>

const sgx_ec256_public_t sgx_pk;

int main()
{
    //init openssl objects
    EC_GROUP *group = EC_GROUP_new_by_curve_name(NID_X9_62_prime256v1);

    BIGNUM *x = BN_new();
    BIGNUM *y = BN_new();

    if (!BN_bin2bn((const unsigned char *)&sgx_pk.gx, sizeof(sgx_pk.gx), x)) {
        // handle error
    }

    if (!BN_bin2bn((const unsigned char *)&sgx_pk.gy, sizeof(sgx_pk.gy), y)) {
        // handle error
    }

    // use x and y

    BN_free(x);
    BN_free(y);
    EC_GROUP_free(group);

    return 0;
}