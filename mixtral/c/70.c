#include <openssl/hmac.h>
#include <openssl/evp.h>
#include <string.h>
#include <openssl/err.h>

static int my_hmac(unsigned char *data, int len, const char *password, unsigned char *hmac)
{
    unsigned char digest[EVP_MD_size(EVP_sha1())];

    OPENSSL_memset(digest, 0, sizeof digest);

    if (!HMAC(EVP_sha1(), password, strlen(password), data, len, digest, NULL)) {
        /* Handle error */
        return -1;
    }

    memcpy(hmac, digest, EVP_MD_size(EVP_sha1()));

    OPENSSL_cleanse(digest, sizeof digest);

    return 0;
}

int main()
{
    unsigned char data[] = "Hello, World!";
    int len = strlen((char*)data);
    const char *password = "my_secret_password";
    unsigned char hmac[EVP_MD_size(EVP_sha1())];

    if (my_hmac(data, len, password, hmac) != 0) {
        ERR_print_errors_fp(stderr);
        return 1;
    }

    return 0;
}