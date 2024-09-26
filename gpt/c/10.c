
#include <openssl/pem.h>
#include <openssl/rsa.h>
#include <openssl/bio.h>
#include <stdio.h>

int main() {
    RSA *private_key = NULL;
    RSA *public_key = NULL;
    FILE *private_key_file = NULL;
    FILE *public_key_file = NULL;

    // Read the private key
    private_key_file = fopen("private_key.pem", "r");
    if (!private_key_file) {
        perror("Failed to open private key file");
        return 1;
    }
    private_key = PEM_read_RSAPrivateKey(private_key_file, NULL, NULL, NULL);
    fclose(private_key_file);
    if (!private_key) {
        fprintf(stderr, "Failed to read private key\n");
        return 1;
    }

    // Read the public key
    public_key_file = fopen("public_key.pem", "r");
    if (!public_key_file) {
        perror("Failed to open
