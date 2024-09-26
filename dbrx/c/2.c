Here is the modified code:


#include <openssl/pkcs12.h>
#include <openssl/x509v3.h>
#include <stdio.h>
#include <string.h>

int main() {
    // Load the PEM-encoded files into BIO objects.
    const char *cert_file = "path/to/certificate.pem";
    const char *key_file = "path/to/private_key.pem";

    FILE *fp_cert = fopen(cert_file, "r");
    if (!fp_cert) return 1;

    X509 *x509;
    PEM_read_X509(fp_cert, &x509, NULL, NULL);
    fclose(fp_cert);

    BIO *bio_key = BIO_new(BIO_s_mem());
    EVP_PKEY *pkey;
    FILE *fp_key = fopen(key_file, "r");
    if (!fp_key) return 1;

    PEM_read_PrivateKey(fp_key, &pkey, NULL, NULL);
    fclose(fp_key);

    // Create a new PKCS#12 structure.
    PKCS12 *pkcs12 = PKCS12_new();
    pkcs12->version = 3;
    ASN1_INTEGER_set(pkcs12->authsafes->type, V_ASN1_SEQUENCE);

    // Add the certificate to the AuthenticatedSafe bag.
    X509_SIG *cert_bag = NULL;
    if (!PKCS12_add_cert(&cert_bag, x509)) return 1;

    PKCS7 *p7 = cert_bag->algor;
    ASN1_OCTET_STRING_set(p7->d.ptr, (const unsigned char *) "12345678", 8);
    p7->type = V_ASN1_SEQUENCE;

    // Add the private key to the AuthenticatedSafe bag.
    PKCS12_SAFEBAG *key_bag = NULL;
    if (!PKCS12_add_key(&key_bag, pkey)) return 1;

    ASN1_OCTET_STRING_set(key_bag->value.keybag->d.ptr, (const unsigned char *) "12345678", 8);
    key_bag->type = V_ASN1_SEQUENCE;

    // Write the PKCS#12 structure to a file.
    const char *output_file = "output.p12";
    FILE *fp_output = fopen(output_file, "wb");
    if (!fp_output) return 1;

    i2d_PKCS12_fp(fp_output, pkcs12);
    fclose(fp_output);

    // Clean up.
    PKCS12_free(pkcs12);
    X509_free(x509);
    EVP_PKEY_free(pkey);
    BIO_free(bio_key);

    return 0;
}