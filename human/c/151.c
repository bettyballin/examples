#include <stdio.h>
#include <algorithm>
#include <openssl/obj_mac.h>
#include <openssl/ec.h>
#include <openssl/err.h>
#include <sgx_tcrypto.h>

extern const sgx_ec256_public_t sgx_pk;
extern const sgx_ec256_private_t sgx_sk;

int main()
{
  //init openssl objects
  EC_GROUP *group = EC_GROUP_new_by_curve_name(NID_X9_62_prime256v1); 
  BN_CTX *bn_ctx = BN_CTX_new();

  //extract affine coordinates from sgx object
  sgx_ec256_public_t sgx_pk_reversed;
  constexpr size_t COORDINATE_SIZE = sizeof(sgx_ec256_public_t) / 2;
  std::reverse_copy(sgx_pk.gx, sgx_pk.gx + COORDINATE_SIZE, sgx_pk_reversed.gx);
  std::reverse_copy(sgx_pk.gy, sgx_pk.gy + COORDINATE_SIZE, sgx_pk_reversed.gy);

  BIGNUM *x = BN_bin2bn((uint8_t*)&sgx_pk_reversed.gx, COORDINATE_SIZE, NULL);
  BIGNUM *y = BN_bin2bn((uint8_t*)&sgx_pk_reversed.gy, COORDINATE_SIZE, NULL);

  //create openssl key and load the coordinates into it
  EC_KEY *ec_key = EC_KEY_new();
  EC_KEY_set_group(ec_key, group);

  if (1 == EC_KEY_set_public_key_affine_coordinates(ec_key, x, y))
    puts("Holy shit it worked.");

  // Clean up
  EC_KEY_free(ec_key);
  BN_free(x);
  BN_free(y);
  BN_CTX_free(bn_ctx);
  EC_GROUP_free(group);

  return 0;
}