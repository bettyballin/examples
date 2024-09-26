#include <wolfssl/openssl/x509.h>

int is_x509_cert(const char* pem_cert_file_path) {
    WOLFSSL_X509 *cert = wolfSSL_X509_load_certificate_file(pem_cert_file_path, SSL_FILETYPE_PEM);
    if (cert != NULL) {
        wolfSSL_X509_free(cert);
        return 1;
    } else {
        return 0;
    }
}

int main() {
    const char* cert_path = "path_to_your_cert.pem";
    int result = is_x509_cert(cert_path);
    return result;
}