#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <openssl/err.h>
#include <string.h>

int main() {
    RSA *rsa = RSA_generate_key(2048, 3, NULL, NULL);
    const char *passphrase = "your_passphrase";
    BIO *bio_private = BIO_new(BIO_s_mem());

    PEM_write_bio_RSAPrivateKey(bio_private, rsa, EVP_aes_256_cbc(), (unsigned char *)passphrase, strlen(passphrase), NULL, NULL);

    // Now you can read the private key from 'bio_private' as a memory buffer.
    char *private_key;
    long private_key_len = BIO_get_mem_data(bio_private, &private_key);
    printf("%.*s\n", (int)private_key_len, private_key);

    RSA_free(rsa);
    BIO_free(bio_private);
    return 0;
}