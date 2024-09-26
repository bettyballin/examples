
char* HashMD5(char* data, DWORD *result)
{
    // ... [rest of the code remains unchanged]

    // Allocate memory for the hash string
    char *strHash = (char*)malloc(33); // 32 characters + 1 for the null-terminator
    if (!strHash)
    {
        // Handle memory allocation failure
        *result = ERROR_NOT_ENOUGH_MEMORY;
        CryptReleaseContext(cryptProv, 0);
        CryptDestroyHash(cryptHash);
        return NULL;
    }

    // ... [rest of the code remains unchanged]

    for(i = 0; i < cbHash; i++)
    {
        strHash[i*2]     = hex
