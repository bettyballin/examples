cpp
#include <Windows.h>
#include <ncrypt.h>

// Clear text for testing
static const char* clearText = "The quick brown fox jumps over the lazy dog. 1234567890.        ";
static const int clearTextLen = 64;

int main()
{
    LPCWSTR keyName = L"NCryptTest";
    SECURITY_STATUS status;
    NCRYPT_PROV_HANDLE hProvider;
    NCRYPT_KEY_HANDLE hKey;

    // Open storage provider
    status = NCryptOpenStorageProvider(&hProvider, NULL, 0);
    if (status != ERROR_SUCCESS)
        return status;

    // Get stored key
    status = NCryptOpenKey(hProvider, &hKey, keyName, 0, 0);
    if (status == NTE_BAD_KEYSET)
    {
        // Create key if it doesn't exist
        status = NCryptCreatePersistedKey(hProvider, &hKey, BCRYPT_AES_ALGORITHM, keyName, 0, 0);
        if (status != ERROR_SUCCESS)
            return status;

        status = NCryptFinalizeKey(hKey, 0);
        if (status != ERROR_SUCCESS)
            return status;
    }
    else if (status != ERROR_SUCCESS)
        return status;

    // Set the chaining mode CBC
    LPCWSTR chainMode = BCRYPT_CHAIN_MODE_CBC;
    status = NCryptSetProperty(hKey, NCRYPT_CHAINING_MODE_PROPERTY, (PBYTE)chainMode, wcslen(chainMode) * 2 + 2, 0);
    if (status != ERROR_SUCCESS)
        return status;

    // Encrypt the text
    DWORD outlen = -1;
    unsigned char* cipherData = new unsigned char[clearTextLen];
    status = NCryptEncrypt(hKey, (PBYTE)clearText, clearTextLen, NULL, cipherData, clearTextLen, &outlen, 0);
    if (status != ERROR_SUCCESS)
        return status;

    // Cleanup
    delete[] cipherData;
    NCryptFreeObject(hKey);
    NCryptFreeObject(hProvider);

    return 0;
}