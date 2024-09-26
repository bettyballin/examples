#include <openssl/evp.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    size_t size;
    unsigned char* data;
} byte_array, *byte_array_ptr;

void handleErrors()
{
    // Handle errors as needed
    ERR_print_errors_fp(stderr);
    abort();
}

int main()
{
    // Example usage
    byte_array_ptr array = malloc(sizeof(byte_array));
    array->size = 10;
    array->data = malloc(array->size);

    // Initialize OpenSSL
    OpenSSL_add_all_algorithms();
    ERR_load_crypto_strings();

    // Example encryption and decryption
    EVP_CIPHER_CTX* ctx = EVP_CIPHER_CTX_new();
    EVP_EncryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, "passwordpassword", "salt");
    EVP_EncryptUpdate(ctx, array->data, &array->size, "Hello, World!", 13);
    EVP_EncryptFinal_ex(ctx, array->data + array->size, &array->size);

    EVP_DecryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, "passwordpassword", "salt");
    EVP_DecryptUpdate(ctx, array->data, &array->size, array->data, array->size);
    EVP_DecryptFinal_ex(ctx, array->data + array->size, &array->size);

    // Cleanup
    EVP_CIPHER_CTX_free(ctx);
    free(array->data);
    free(array);

    return 0;
}