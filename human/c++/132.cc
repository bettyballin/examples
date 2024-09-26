cpp
#include <iostream>
#include <openssl/evp.h>
#include <openssl/pem.h>
#include <openssl/err.h>

int main() {
    EVP_PKEY *pkey = NULL;
    unsigned char *pkey_buf = NULL;
    int pkey_len;

    // Generate a new RSA key pair
    RSA *rsa = RSA_new();
    BIGNUM *bne = BN_new();
    BN_set_word(bne, RSA_F4);
    RSA_generate_key_ex(rsa, 2048, bne, NULL);
    pkey = EVP_PKEY_new();
    EVP_PKEY_assign_RSA(pkey, rsa);

    // Encode the public key
    pkey_len = i2d_PUBKEY(pkey, &pkey_buf);

    // Decode the public key
    EVP_PKEY *decoded_pkey = d2i_PUBKEY(NULL, &pkey_buf, pkey_len);

    // Print the decoded public key
    BIO *bio = BIO_new(BIO_s_mem());
    PEM_write_bio_PUBKEY(bio, decoded_pkey);
    char *buf;
    long len = BIO_get_mem_data(bio, &buf);
    std::cout << std::string(buf, len) << std::endl;

    // Free memory
    EVP_PKEY_free(pkey);
    EVP_PKEY_free(decoded_pkey);
    free(pkey_buf);
    BIO_free(bio);
    return 0;
}