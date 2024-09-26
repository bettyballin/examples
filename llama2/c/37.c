#include <openssl/ssl.h>
#include <openssl/err.h>
#include <openssl/ec.h>
#include <openssl/rand.h>
#include <openssl/evp.h>

int main()
{
    // Initialize OpenSSL
    OpenSSL_add_all_algorithms();
    ERR_load_crypto_strings();

    // Generate a random symmetric key
    unsigned char sym_key[32];
    RAND_bytes(sym_key, sizeof(sym_key));

    // Set recipient's public key
    EC_KEY *ec_key = EC_KEY_new_by_curve_name(NID_X9_62_prime256v1);
    unsigned char recipient_public_key[65] = { /* insert recipient's public key in uncompressed format */ };
    EC_KEY_oct2key(ec_key, recipient_public_key, 65, NULL);

    // Compute the shared secret using ECDH
    unsigned char shared_secret[32];
    size_t shared_secret_len = sizeof(shared_secret);
    ECDH_compute_key(ec_key, sym_key, sizeof(sym_key), shared_secret, &shared_secret_len);

    // Encrypt the symmetric key using AES-GCM with a randomly generated IV
    EVP_CIPHER_CTX *ctx;
    EVP_CIPHER_CTX_init(&ctx);
    EVP_EncryptInit_ex(ctx, EVP_aes_256_gcm(), NULL, shared_secret, NULL);
    unsigned char iv[12];
    RAND_bytes(iv, sizeof(iv));
    EVP_EncryptInit_ex(ctx, NULL, NULL, NULL, iv);
    unsigned char encrypted_sym_key[64];
    int encrypted_sym_key_len = sizeof(encrypted_sym_key);
    EVP_EncryptUpdate(ctx, encrypted_sym_key, &encrypted_sym_key_len, sym_key, sizeof(sym_key));
    EVP_EncryptFinal_ex(ctx, encrypted_sym_key + encrypted_sym_key_len, &encrypted_sym_key_len);
    EVP_CIPHER_CTX_cleanup(ctx);

    // Clean up
    EC_KEY_free(ec_key);
    EVP_cleanup();
    CRYPTO_cleanup_all_ex_data();
    ERR_free_strings();

    return 0;
}