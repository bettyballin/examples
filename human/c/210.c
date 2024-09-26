#include <Security/Security.h>
#include <CoreFoundation/CoreFoundation.h>

CFStringRef createDistinguishedName(CFDictionaryRef certValues, CFTypeRef oid) {
    CFArrayRef values = CFDictionaryGetValue(certValues, oid);
    CFStringRef dn = CFArrayGetValueAtIndex(values, 0);
    return dn;
}

void printDN(CFDataRef certData) {
    SecCertificateRef certRef = SecCertificateCreateWithData(NULL, certData);
    CFDictionaryRef certValues = SecCertificateCopyValues(certRef, nil, nil);
    CFStringRef dn = createDistinguishedName(certValues, kSecOIDX509V1IssuerName);
    CFShow(dn);
    CFRelease(dn);
    CFRelease(certValues);
    CFRelease(certRef);
}

int main() {
    // Example usage:
    const char certBytes[] = /* your certificate bytes here */;
    size_t certLen = sizeof(certBytes);
    CFDataRef certData = CFDataCreate(NULL, (const UInt8*)certBytes, certLen);
    printDN(certData);
    CFRelease(certData);
    return 0;
}