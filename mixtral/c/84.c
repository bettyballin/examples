#include <stdio.h>
#include <wolfssl/options.h>
#include <wolfssl/wolfssl.h>
#include <wolfssl/ssl.h>
#include <wolfssl/x509_vfy.h>

int main() {
    const char* certPem = "-----BEGIN CERTIFICATE-----"
                          "<Your Base64 encoded certificate data here>"
                          "-----END CERTIFICATE-----";

    WOLFSSL_CTX *ctx;

    wolfSSL_Init();

    ctx = wolfSSL_CTX_new(wolfTLSv1_2_client_method());

    if (ctx == NULL) {
        printf("Failed to create context\n");
        return -1;
    }

    WOLFSSL_X509 *certificate = wolfSSL_X509_load_certificate_buffer(certPem, strlen(certPem), WOLFSSL_FILETYPE_PEM, NULL);

    if (!certificate || wolfSSL_X509_check_private_key(certificate) != SSL_SUCCESS) {
        printf("Invalid certificate\n");

        // Cleanup
        wolfSSL_X509_free(certificate);

        wolfSSL_CTX_free(ctx);

        return -1;
    }

    printf("Certificate is valid.\n");

    // Clean up
    wolfSSL_X509_free(certificate);

    wolfSSL_CTX_free(ctx);

    wolfSSL_Cleanup();

    return 0;
}