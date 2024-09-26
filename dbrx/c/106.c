#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <gnutls/gnutls.h>
#include <gnutls/crypto.h> // For gnutls_cipher_init

#define KEY_LENGTH 32
#define IV_LENGTH 16

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s input_file output_file\n", argv[0]);
        return 1;
    }

    int ret;

    const char *input_filename = argv[1];
    const char *output_filename = argv[2];

    gnutls_global_init();

    // Initialize the session and cipher handle
    gnutls_cipher_hd_t handle;
    gnutls_datum_t key, iv;
    gnutls_datum_t encrypted_data;

    key.data = malloc(KEY_LENGTH);
    key.size = KEY_LENGTH;
    iv.data = malloc(IV_LENGTH);
    iv.size = IV_LENGTH;

    ret = gnutls_cipher_init(&handle, GNUTLS_CIPHER_AES_256_CBC, &key, &iv);
    if (ret < 0) {
        fprintf(stderr, "Error initializing cipher: %s\n", gnutls_strerror(ret));
        return 1;
    }

    // Open the input and output files
    FILE *input_file = fopen(input_filename, "rb");
    FILE *output_file = fopen(output_filename, "wb");

    if (!input_file || !output_file) {
        perror("Error opening files");
        gnutls_cipher_deinit(handle);
        return 1;
    }

    fseek(input_file, 0, SEEK_END);
    long input_size = ftell(input_file);
    rewind(input_file);

    char *input_data = malloc(input_size);
    fread(input_data, 1, input_size, input_file);

    encrypted_data.data = malloc(input_size);
    encrypted_data.size = input_size;

    ret = gnutls_cipher_encrypt(handle, input_data, input_size, encrypted_data.data, &encrypted_data.size);
    if (ret < 0) {
        fprintf(stderr, "Error encrypting data: %s\n", gnutls_strerror(ret));
        return 1;
    }

    fwrite(encrypted_data.data, 1, encrypted_data.size, output_file);

    fclose(input_file);
    fclose(output_file);

    gnutls_cipher_deinit(handle);
    gnutls_global_deinit();

    free(key.data);
    free(iv.data);
    free(input_data);
    free(encrypted_data.data);

    return 0;
}