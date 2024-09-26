
#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <openssl/err.h>

void generate_keys() {
    int             bits = 2048;
    unsigned long   e = RSA_F4;
    RSA             *rsa = NULL;
    BIGNUM          *bignum = NULL;
    
    bignum = BN_new();
    BN_set_word(bignum, e);

    // Generate the RSA key pair
    rsa = RSA_new();
    RSA_generate_key_ex(rsa, bits, bignum, NULL);

    // To get the public key
    BIO *pub = BIO_new(BIO_s_mem());
    PEM_write_bio_RSAPublicKey(pub, rsa);

    // To get the private key
    BIO *priv =
