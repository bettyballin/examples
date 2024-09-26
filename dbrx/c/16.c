#include <openssl/pkcs7.h>
#include <openssl/x509.h>
#include <openssl/bio.h>

int main() {
    PKCS7 *p7 = NULL;
    STACK_OF(X509) *certs_stack = sk_X509_new_null();
    X509_STORE *store = X509_STORE_new();

    // Add your root certificate to the store.
    X509 *x509_root_certificate = NULL; // replace with your root certificate
    X509_STORE_add_cert(store, x509_root_certificate);

    BIO *in_bio = BIO_new(BIO_s_mem());
    char data[] = "Hello, World!"; // data to write
    BIO_write(in_bio, data, strlen(data));

    // don't forget to free resources
    BIO_free(in_bio);
    X509_STORE_free(store);
    sk_X509_free(certs_stack);
    PKCS7_free(p7);

    return 0;
}