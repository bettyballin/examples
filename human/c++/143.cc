cpp
#include <windows.h>
#include <wincrypt.h>
#include <ncrypt.h>

int main()
{
    const wchar_t* subjectName = L"example.com"; // replace with your subject name

    HCERTSTORE store = CertOpenStore(CERT_STORE_PROV_SYSTEM_W, X509_ASN_ENCODING | PKCS_7_ASN_ENCODING, 0, CERT_SYSTEM_STORE_LOCAL_MACHINE | CERT_STORE_READONLY_FLAG, (const void*)L"MY");
    if (!store) {
        // handle error
        return 1;
    }

    PCCERT_CONTEXT certContext = CertFindCertificateInStore(store, X509_ASN_ENCODING | PKCS_7_ASN_ENCODING, 0, CERT_FIND_SUBJECT_STR_W, subjectName, nullptr);
    if (certContext)
    {
        HCRYPTPROV_OR_NCRYPT_KEY_HANDLE keyHandle;
        DWORD keySpec;
        BOOL callerFreesKeyHandle;

        if (CryptAcquireCertificatePrivateKey(certContext, CRYPT_ACQUIRE_SILENT_FLAG | CRYPT_ACQUIRE_ONLY_NCRYPT_KEY_FLAG, nullptr, &keyHandle, &keySpec, &callerFreesKeyHandle))
        {
            if (keySpec != CERT_NCRYPT_KEY_SPEC) {
                // handle error
                return 1;
            }

            if (callerFreesKeyHandle)
            {
                NCryptFreeObject(keyHandle);
            }
        }
        else {
            // handle error
        }
        CertFreeCertificateContext(certContext);
    }
    else {
        // handle error
    }
    CertCloseStore(store, 0);

    return 0;
}