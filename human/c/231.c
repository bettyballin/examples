#include <gnutls/gnutls.h>

int main() {
    gnutls_cipher_hd_t handle;
    const char* ptext = "Hello, World!";
    size_t ptext_len = strlen(ptext);
    char ctext[256];
    size_t ctext_len = 256;

    // Initialize GnuTLS
    gnutls_global_init();

    // Create a cipher handle
    gnutls_cipher_init(&handle, GNUTLS_CIPHER_AES_256_CBC, GNUTLS_CIPHER_MODE_ENCRYPT, NULL);

    // Set the key
    unsigned char key[32];
    gnutls_cipher_setkey(handle, key, 32);

    // Set the IV
    unsigned char iv[16];
    gnutls_cipher_setiv(handle, iv, 16);

    // Encrypt the plaintext
    int ret = gnutls_cipher_encrypt2(handle, ptext, ptext_len, ctext, &ctext_len);

    // Check the result
    if (ret != 0) {
        printf("Encryption failed: %s\n", gnutls_strerror(ret));
    } else {
        printf("Encrypted text: %s\n", ctext);
    }

    // Deinitialize the cipher handle
    gnutls_cipher_deinit(handle);

    // Deinitialize GnuTLS
    gnutls_global_deinit();

    return 0;
}