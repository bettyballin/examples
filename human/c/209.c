#include <CoreFoundation/CoreFoundation.h>
#include <Security/Security.h>

static CFStringRef createDistinguishedName(CFDictionaryRef certValues, CFStringRef key) {
    CFDictionaryRef dict = CFDictionaryGetValue(certValues, key);
    CFArrayRef values = CFDictionaryGetValue(dict, kSecPropertyKeyValue);
    
    CFMutableStringRef dn = CFStringCreateMutableCopy(NULL, 0, CFSTR(""));
    
    CFStringRef keys[] = { kSecOIDCommonName, kSecOIDOrganizationName, kSecOIDOrganizationalUnitName, kSecOIDLocalityName, kSecOIDStateProvinceName, kSecOIDCountryName, kSecOIDSerialNumber, kSecOIDEmailAddress};
    CFStringRef txt[] = { CFSTR("CN"), CFSTR("O"), CFSTR("OU"), CFSTR("L"), CFSTR("S"), CFSTR("C"), CFSTR("SERIALNUMBER"), CFSTR("MAIL")};
    
    bool appendComa = false;
    for(int i = 0; i < CFArrayGetCount(values); i++) {
        CFDictionaryRef subDict = CFArrayGetValueAtIndex(values, i);
        CFStringRef labelVal = CFDictionaryGetValue(subDict, kSecPropertyKeyLabel);
        
        for(int k = 0; k < sizeof(keys)/sizeof(keys[0]); k++) {
            if (kCFCompareEqualTo == CFStringCompare(labelVal, keys[k], 0)) {
                if (appendComa)
                    CFStringAppend(dn, CFSTR(", "));
                CFStringAppend(dn, txt[k]);
                CFStringAppend(dn, CFSTR("="));
                CFStringAppend(dn, CFDictionaryGetValue(subDict, kSecPropertyKeyValue));
                appendComa = true;
            }
        }
    }
    return dn;
}

int main() {
    // Example usage:
    CFDictionaryRef certValues = ...; // Load certificate values
    CFStringRef key = ...; // Load key
    CFStringRef dn = createDistinguishedName(certValues, key);
    CFShow(dn);
    CFRelease(dn);
    return 0;
}