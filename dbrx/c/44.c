#include <stdio.h>
#include <openssl/rsa.h>
#include <openssl/err.h>

int main() {
    unsigned char encrypted[256];
    unsigned char random_password[32];
    RSA *rsa;
    int padding = RSA_PKCS1_OAEP_PADDING;
    int len;

    // Generate a random password
    for (int i = 0; i < 32; i++) {
        random_password[i] = (unsigned char) rand() % 256;
    }

    // Load RSA key
    rsa = RSA_new();
    // Replace "path/to/public/key" with your actual public key file
    FILE *fp = fopen("path/to/public/key", "r");
    rsa = PEM_read_RSAPublicKey(fp, &rsa, NULL, NULL);
    fclose(fp);

    // Encrypt the password
    len = RSA_public_encrypt(32, random_password, encrypted, rsa, padding);

    // Print the encrypted password
    for (int i = 0; i < len; i++) {
        printf("%02x", encrypted[i]);
    }
    printf("\n");

    // Free the RSA key
    RSA_free(rsa);

    return 0;
}