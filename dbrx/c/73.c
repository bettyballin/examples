Here is the modified code:


#include <wolfssl/wolfcrypt/asn.h>
#include <wolfssl/wolfcrypt/coding.h>
#include <stdio.h>
#include <string.h>

int is_valid_certificate(const char* pem_cert)
{
    int ret;
    word32 idx = 0, cert_len = (word32)strlen(pem_cert);
    byte der_buf[4096];
    DecodedCert decoded;

    if (!pem_cert || !cert_len)
        return BAD_FUNC_ARG;

    /* Decode PEM to DER */
    ret = PemToDer((byte*)pem_cert, cert_len, NULL, 0, CERT_TYPE, &idx);
    if (ret < 0) {
        printf("Error decoding certificate: %d\n", ret);
        return -1;
    }

    /* Parse the decoded buffer as a DER-encoded X.509 certificate */
    InitDecodedCert(&decoded, der_buf, sizeof(der_buf), NULL);
    ret = DecodeToPem((byte*)pem_cert + idx, cert_len - idx, CERT_TYPE, &decoded, 0);
    if (ret < 0) {
        printf("Error parsing certificate: %d\n", ret);
        FreeDecodedCert(&decoded);
        return -1;
    }

    /* Check the parsed result */
    if (!decoded.subject.raw || !decoded.issuer.raw ||
        decoded.sigOID != SIG_OID_SHA256WITHECDSA) {
        printf("Invalid or unsupported certificate format.\n");
        ret = BAD_CERT_FORMAT_E;
    }
    else
        ret = 0; /* Certificate is valid */

    FreeDecodedCert(&decoded);
    return ret;
}

int main() {
    const char* pem_cert = "your_certificate_here";
    int ret = is_valid_certificate(pem_cert);
    printf("Certificate validation result: %d\n", ret);
    return 0;
}