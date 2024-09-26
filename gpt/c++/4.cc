
int RSAKeyGen(int keySize) {

    EVP_PKEY *pkey = EVP_PKEY_new();

    BIGNUM *bn = BN_new();
    BN_set_word(bn, RSA_F4);

    RSA *rsa = RSA_new();
    RSA_generate_key_ex(rsa, keySize, bn, NULL);

    EVP_PKEY_assign_RSA(pkey, rsa);

    const BIGNUM *
