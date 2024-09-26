#include <stdio.h>
#include <openssl/cms.h>
#include <openssl/err.h>
#include <openssl/pem.h>
#include <openssl/x509.h>

int testcms (const char* cert_path, const char* sod_path)
{
    BIO *in = NULL, *out = NULL, *tbio = NULL, *cont = NULL;
    X509_STORE *st = NULL;
    X509 *cacert = NULL;
    CMS_ContentInfo *cms = NULL;

    int ret = 1;

    OpenSSL_add_all_algorithms();
    ERR_load_crypto_strings();

    st = X509_STORE_new();

    tbio = BIO_new_file(cert_path, "r");

    if (!tbio) {
        fprintf(stderr, "Cert file not opened: path=%s;\n", cert_path);
        goto err;
    }

    cacert = PEM_read_bio_X509(tbio, NULL, 0, NULL);

    if (!cacert) {
        fprintf(stderr, "PEM_read_bio_X509 FAILED: cert.path=%s;\n", cert_path);
        goto err;
    }

    if (!X509_STORE_add_cert(st, cacert)) {
        fprintf(stderr, "X509_STORE_add_cert FAILED: cert.path=%s;\n", cert_path);
        goto err;
    }

    in = BIO_new_file(sod_path, "r");

    if (!in) {
        fprintf(stderr, "PKCS7 file not opened: path=%s;\n", sod_path);
        goto err;
    }

    //cms = SMIME_read_CMS(in, &cont);
    cms = d2i_CMS_bio(in, NULL);

    if (!cms) {
        fprintf(stderr, "SMIME_read_CMS FAILED: pkcs7.path=%s;\n", sod_path);
        goto err;
    }

    if (!CMS_verify(cms, NULL, st, cont, NULL, 0)) {
        fprintf(stderr, "Verification Failure\n");
        goto err;
    }

    fprintf(stderr, "Verification Successful\n");

    ret = 0;

err:

    if (ret) {
        fprintf(stderr, "Error Verifying Data\n");
        ERR_print_errors_fp(stderr);
    }

    CMS_ContentInfo_free(cms);
    X509_free(cacert);
    BIO_free(in);
    BIO_free(out);
    BIO_free(tbio);
    X509_STORE_free(st);
    return ret;
}

int main() {
    const char* cert_path = "path/to/cert.pem";
    const char* sod_path = "path/to/sod.der";
    return testcms(cert_path, sod_path);
}