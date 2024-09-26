I can assist with that. Here is the modified C code:



#include <stdio.h>
#include <stdlib.h>
#include <openssl/pkcs7.h>
#include <openssl/pem.h>
#include <openssl/x509.h>
#include <openssl/err.h>

int verify(const char *certfile, const char *p7file) {
    FILE *fp;
    X509_STORE *store = NULL;
    STACK_OF(X509) *chain = sk_X509_new_null();

    PKCS7 *pkcs7 = d2i_PKCS7_fp(fopen(p7file, "r"), NULL);

    fp = fopen(certfile, "rb");

    X509 *x;

    while ((x = PEM_read_X509(fp, NULL, NULL, NULL))) {
        sk_X509_push(chain, x);

        if (!store)
            store = X509_STORE_new();

        // Add the certificate to our trusted certificates
        X509_STORE_add_cert(store, x);
    }

    fclose(fp);

    int ret;

    if (pkcs7 && chain) {

       /* Verify PKCS#7 signature */

        ret = PKCS7_verify(pkcs7, chain, store, NULL, NULL, 0);

        printf("PKCS7 verify: %s\n", (ret == 1) ? "OK" : "failure");

    }

   // Free memory

    sk_X509_pop_free(chain, X509_free);

    if (store != NULL)
        X509_STORE_free(store);

    PKCS7_free(pkcs7);

   return ret;
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s certfile p7file\n", argv[0]);
        return 1;
    }
    return verify(argv[1], argv[2]);
}