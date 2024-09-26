cpp
#include <Windows.h>
#include <Wincrypt.h>
#include <vector>

int main() {
    HCRYPTPROV hCryptProv;
    CryptAcquireContext(&hCryptProv, NULL, NULL, PROV_RSA_FULL, 0);

    HCRYPTKEY hCryptKey;
    CryptImportKey(hCryptProv, privateKey.pbKey, privateKey.cbKey, 0, 0, &hCryptKey);

    std::vector<BYTE> data(cipherArr.size());
    DWORD dataSize = data.size();
    CryptDecrypt(hCryptKey, 0, TRUE, 0, cipherArr.data(), &dataSize);

    CryptDestroyKey(hCryptKey);
    CryptReleaseContext(hCryptProv, 0);

    return 0;
}