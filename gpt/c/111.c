
#include <stdio.h>
#include <wolfssl/options.h>
#include <wolfssl/ssl.h>
#include <wolfssl/wolfcrypt/error-crypt.h>

int check_certificate(const char* certPath) {
    WOLFSSL_CERT_MANAGER* cm = NULL;
    int ret = 0;

    /* Initialize wolfSSL library */
    wolfSSL_Init();

    /* Create a new certificate manager */
    cm = wolfSSL_CertManagerNew();
    if (cm == NULL) {
        printf("wolfSSL_CertManagerNew() failed\n");
        ret = -1;
        goto cleanup;
    }

    /* Attempt to load the certificate */
    ret = wolfSSL_CertManagerLoadCABuffer(cm, certPath, strlen(certPath), WOLFSSL_FILETYPE_PEM);
    if (ret != WOLFSSL_SUCCESS)
