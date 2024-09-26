#include <openssl/rsa.h>
#include <openssl/err.h>

int main() {
    unsigned char encrypted_password[32] = /* your encrypted password */;
    RSA *rsa = /* your RSA private key */;
    int padding = /* your padding scheme */;

    unsigned char decrypted[256];
    int len = RSA_private_decrypt(32, encrypted_password, decrypted, rsa, padding);

    if (len < 0) {
        unsigned long err = ERR_get_error();
        char *err_msg = ERR_error_string(err, NULL);
        printf("Error: %s\n", err_msg);
    } else {
        printf("Decrypted password length: %d\n", len);
        printf("Decrypted password: %s\n", decrypted);
    }

    return 0;
}