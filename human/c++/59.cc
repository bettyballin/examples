cpp
#include <Windows.h>
#include <wincrypt.h>
#include <atlenc.h>
#include <atlbase.h>
#include <string>
#include <iostream>

int main() {
    LPCSTR      lpszSomeSecret  = "Some Secret To Be Hashed" ;
    std::string strEncodedHash  ; // the resulting hash. 

    HCRYPTPROV  hProv           = NULL ;
    HCRYPTHASH  hHash           = NULL ;
    DWORD       cbSomeSecret    = (DWORD)::strlen(lpszSomeSecret) ;
    BYTE*       pbHash          = NULL ;
    DWORD       cbHash          = 0 ;
    DWORD       cbHashSize      = (DWORD)sizeof(cbHash) ;
    LPSTR       pchEncodedHash  = NULL ;
    int         cbEncodedHash   = 0 ;

    HRESULT hResult = S_OK ;

    if (!::CryptAcquireContext(&hProv, NULL, NULL, PROV_RSA_FULL, 0)) {
        hResult = ::AtlHresultFromLastError() ;
    } else if (!::CryptCreateHash(hProv, CALG_MD5, 0, 0, &hHash)) {
        hResult = ::AtlHresultFromLastError() ;
    } else if (!::CryptHashData(hHash, (BYTE*)lpszSomeSecret, cbSomeSecret, 0)) {
        hResult = ::AtlHresultFromLastError() ;
    } else if (!::CryptGetHashParam(hHash, HP_HASHSIZE, (BYTE*)&cbHash, &cbHashSize, 0)) {
        hResult = ::AtlHresultFromLastError() ;
    } else if ((pbHash = (BYTE*)::malloc(cbHash)) == NULL) {
        hResult = E_OUTOFMEMORY ;
    } else if (!::CryptGetHashParam(hHash, HP_HASHVAL, pbHash, &cbHash, 0)) {
        hResult = ::AtlHresultFromLastError() ;
    } else if ((pchEncodedHash = (LPSTR)::malloc(
                (cbEncodedHash = ::Base64EncodeGetRequiredLength(cbHash, ATL_BASE64_FLAG_NOPAD | ATL_BASE64_FLAG_NOCRLF))
                )) == NULL) {
        hResult = E_OUTOFMEMORY ;
    } else if (!::Base64Encode(pbHash, cbHash, pchEncodedHash, &cbEncodedHash, ATL_BASE64_FLAG_NOPAD | ATL_BASE64_FLAG_NOCRLF)) {
        hResult = E_FAIL ;
    } else {
        strEncodedHash.assign(pchEncodedHash, cbEncodedHash) ;
    }

    if (pchEncodedHash) ::free(pchEncodedHash) ;
    if (pbHash)         ::free(pbHash) ;
    if (hProv)          ::CryptReleaseContext(hProv, 0) ;
    if (hHash)          ::CryptDestroyHash(hHash) ;

    std::cout << strEncodedHash << std::endl;

    return 0;
}