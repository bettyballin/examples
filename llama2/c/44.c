#include <openssl/ssl.h>
#include <stdio.h>
#include <string.h>

int main()
{
    // Create a SSL context
    SSL_CTX* ctx = SSL_CTX_new(TLS_client_method());

    // Connect to the server
    SSL* ssl = SSL_new(ctx);
    BIO* bio = BIO_new_connect("www.example.com:443");
    SSL_set_bio(ssl, bio, bio);
    SSL_connect(ssl);

    // Retrieve the client hello message
    // Note: There is no direct way to retrieve client hello in OpenSSL.
    // The following code will print the OpenSSL version used by the client.

    printf("Client is using OpenSSL version: %s\n", SSLeay_version(SSLEAY_VERSION));

    // Clean up
    SSL_free(ssl);
    SSL_CTX_free(ctx);

    return 0;
}