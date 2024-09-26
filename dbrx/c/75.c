#include <openssl/ec.h>
#include <openssl/cms.h>
#include <openssl/err.h>

int main() {
    EC_KEY *ecc_private_key = EC_KEY_new_by_curve_name(NID_secp384r1);
    EC_KEY *ecc_public_key = EC_KEY_new();
    const BIGNUM *privkey_bn;
    EVP_PKEY *pkey;

    if (!EC_KEY_generate_key(ecc_private_key)) {
        ERR_print_errors_fp(stderr);
        return 1;
    }

    // Extract the private key as a big number for later use.
    privkey_bn = EC_KEY_get0_private_key(ecc_private_key);

    // Set up public key from generated ECC keys.
    const EC_GROUP *group = EC_KEY_get0_group(ecc_private_key);
    EC_POINT *pub_point = EC_POINT_new(group); 
    if (!EC_POINT_mul(group, pub_point, privkey_bn, NULL, NULL, NULL)) {
        ERR_print_errors_fp(stderr);
        return 1;
    }
    EC_KEY_set_public_key(ecc_public_key, pub_point);

    // Create CMS_RecipientInfo structure with ECC public key.
    EVP_PKEY_assign_EC_KEY(pkey, ecc_public_key);
    CMS_ContentInfo *cms_ci = CMS_encrypt(NULL, &pkey, EVP_aes_256_cbc(), 0);
    if (!cms_ci) {
        ERR_print_errors_fp(stderr);
        return 1;
    }

    // Extract the encrypted symmetric key from recipient info.
    const ASN1_OCTET_STRING *encrypted_symmetric_key;
    int rc = CMS_get0_ciphertext(cms_ci, &encrypted_symmetric_key);
    if (rc != 1) {
        ERR_print_errors_fp(stderr);
        return 1;
    }

    // Print the encrypted symmetric key
    unsigned char *symmetric_key = ASN1_STRING_get0_data(encrypted_symmetric_key);
    int symmetric_key_len = ASN1_STRING_length(encrypted_symmetric_key);
    for (int i = 0; i < symmetric_key_len; i++) {
        printf("%02x", symmetric_key[i]);
    }
    printf("\n");

    EC_KEY_free(ecc_private_key);
    EC_KEY_free(ecc_public_key);
    EC_POINT_free(pub_point);
    EVP_PKEY_free(pkey);
    CMS_ContentInfo_free(cms_ci);

    return 0;
}