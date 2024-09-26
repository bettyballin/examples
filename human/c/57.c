Here is the modified code:

#include <openssl/ssl.h>
#include <openssl/err.h>
#include <openssl/pkcs7.h>
#include <openssl/x509.h>
#include <openssl/bio.h>

int main() {
    OpenSSL_add_all_algorithms();
    OpenSSL_add_all_digests();
    EVP_add_digest(EVP_md5());
    EVP_add_digest(EVP_sha1());
    EVP_add_digest(EVP_sha256());

    unsigned char *sig = /* your signature */;
    int sig_length = /* your signature length */;
    unsigned char *data = /* your data */;
    int data_length = /* your data length */;

    BIO* sig_BIO = BIO_new_mem_buf(sig, sig_length);
    PKCS7* sig_pkcs7 = d2i_PKCS7_bio(sig_BIO, NULL);

    BIO* data_BIO = BIO_new_mem_buf(data, data_length);
    BIO* data_pkcs7_BIO = PKCS7_dataInit(sig_pkcs7, data_BIO);

    // Goto this place in the BIO. Why? No idea!
    char unneeded[1024*4];
    while (BIO_read(data_pkcs7_BIO, unneeded, sizeof(unneeded)) > 0);

    int result;
    X509_STORE *certificateStore = X509_STORE_new();
    X509_STORE_CTX certificateContext;
    STACK_OF(PKCS7_SIGNER_INFO) *signerStack = PKCS7_get_signer_info(sig_pkcs7);
    int numSignerInfo = sk_PKCS7_SIGNER_INFO_num(signerStack);
    for (int i=0; i<numSignerInfo; ++i) {
        PKCS7_SIGNER_INFO *signerInfo = sk_PKCS7_SIGNER_INFO_value(signerStack, i);
        result = PKCS7_dataVerify(certificateStore, &certificateContext, data_pkcs7_BIO, sig_pkcs7, signerInfo);
    }

    X509_STORE_CTX_cleanup(&certificateContext);
    BIO_free(sig_BIO);
    BIO_free(data_BIO);
    BIO_free(data_pkcs7_BIO);
    PKCS7_free(sig_pkcs7);
    X509_STORE_free(certificateStore);

    return 0;
}

Note: You'll need to fill in the `sig`, `sig_length`, `data`, and `data_length` variables with your actual data.