#include <Windows.h>
#include <Wincrypt.h>

DWORD HashMD5(const char* plaintext, DWORD* result)
{
    // Generate a new random key for this invocation
    BYTE key[16];
    RtlGenRandom(key, sizeof(key));

    // Create a hash object using the random key
    HCRYPTPROV hCryptProv = 0;
    HCRYPTHASH Hash = 0;
    if(CryptAcquireContext(&hCryptProv, NULL, NULL, PROV_RSA_AES, CRYPT_VERIFYCONTEXT))
    {
        // Create a hash object
        if(CryptCreateHash(hCryptProv, CALG_MD5, 0, 0, &Hash))
        {
            // Set the key for the hash
            CryptSetKeyParam(Hash, KP_KEY, key, sizeof(key));

            // Hash the data
            BYTE* plaintextBytes = (BYTE*)plaintext;
            DWORD plaintextSize = strlen(plaintext);
            CryptHashData(Hash, plaintextBytes, plaintextSize, 0);

            // Get the hash value
            BYTE hashValue[16];
            DWORD hashSize = sizeof(hashValue);
            CryptGetHashParam(Hash, HP_HASHVAL, hashValue, &hashSize, 0);

            // Copy the hash value to the result
            memcpy(result, hashValue, sizeof(hashValue));

            // Clean up
            CryptDestroyHash(Hash);
        }
        CryptReleaseContext(hCryptProv, 0);
    }
    return 0;
}

int main() {
    const char* plaintext = "Hello, World!";
    DWORD result[4];
    HashMD5(plaintext, result);
    return 0;
}