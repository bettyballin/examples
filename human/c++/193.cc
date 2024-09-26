cpp
#include <Security/Security.h>
#include <openssl/x509.h>

int main() {
    SecCertificateRef cert = ...; // Initialize with a valid certificate

    CFDataRef data = SecCertificateCopyData(cert);
    auto dataBufferPointer = CFDataGetBytePtr(data);
    X509 *certificateX509 = d2i_X509(NULL, &dataBufferPointer, CFDataGetLength(data));

    // Don't forget to free the memory
    CFRelease(data);
    X509_free(certificateX509);

    return 0;
}