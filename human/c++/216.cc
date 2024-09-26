cpp
#include <Windows.h>
#include <bcrypt.h>
#include <wincrypt.h>
#include <stdio.h>

inline ULONG BOOL_TO_ERROR(BOOL f)
{
    return f ? NOERROR : GetLastError();
}

ULONG PemToCNG(_In_ PCSTR pszString, _Out_ BCRYPT_KEY_HANDLE* phKey)
{
    PBYTE pb = 0;
    ULONG cb = 0;

    ULONG dwError;

    while (NOERROR == (dwError = BOOL_TO_ERROR(
        CryptStringToBinaryA(pszString, 0, CRYPT_STRING_BASE64_ANY, pb, &cb, 0, 0))))
    {
        if (pb)
        {
            PCERT_PUBLIC_KEY_INFO PublicKeyInfo;

            if (NOERROR == (dwError = BOOL_TO_ERROR(CryptDecodeObjectEx(
                X509_ASN_ENCODING | PKCS_7_ASN_ENCODING, 
                X509_PUBLIC_KEY_INFO, pb, cb, 
                CRYPT_DECODE_ALLOC_FLAG|
                CRYPT_DECODE_NOCOPY_FLAG|
                CRYPT_DECODE_SHARE_OID_STRING_FLAG, 
                0, &PublicKeyInfo, &cb))))
            {
                dwError = BOOL_TO_ERROR(CryptImportPublicKeyInfoEx2(
                    X509_ASN_ENCODING, PublicKeyInfo, 0, 0, phKey));

                LocalFree(PublicKeyInfo);
            }
            break;
        }

        if (!(pb = (PBYTE)LocalAlloc(0, cb)))
        {
            dwError = GetLastError();
            break;
        }
    }

    if (pb)
    {
        LocalFree(pb);
    }

    return dwError;
}

void TestPem()
{
    static const char Pem[] = 
        "-----BEGIN PUBLIC KEY-----\r\n"
        "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAETHfi8foQF4UtSNVxSFxeu7W+gMxd\r\n"
        "SGElhdo7825SD3Lyb+Sqh4G6Kra0ro1BdrM6Qx+hsUx4Qwdby7QY0pzxyA==\r\n"
        "-----END PUBLIC KEY-----";

    BCRYPT_KEY_HANDLE hKey;
    if (NOERROR == PemToCNG(Pem, &hKey))
    {
        PBYTE pb = 0;
        ULONG cb = 0;
        while (0 <= BCryptExportKey(hKey, 0, BCRYPT_PUBLIC_KEY_BLOB, pb, cb, &cb, 0))
        {
            if (pb)
            {
                PSTR psz = 0;
                ULONG cch = 0;
                while (CryptBinaryToStringA(pb, cb, CRYPT_STRING_HEXASCII, psz, &cch))
                {
                    if (psz)
                    {
                        printf("%s\n", psz);
                        break;
                    }

                    psz = (PSTR)alloca(cch * sizeof(char));
                }
                break;
            }

            pb = (PBYTE)alloca(cb);
        }

        BCryptDestroyKey(hKey);
    }
}

int main()
{
    TestPem();
    return 0;
}


Note: You need to link against `bcrypt.lib` and `crypt32.lib` for this code to work. You can do this by adding the following lines to your project settings:


/LIBPATH:"C:\Program Files (x86)\Windows Kits\10\Lib\10.0.19041.0\um\x86"
bcrypt.lib
crypt32.lib