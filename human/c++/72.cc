cpp
#include <Windows.h>
#include <stdio.h>

int main() {
    DWORD blockSize = CRYPTPROTECTMEMORY_BLOCK_SIZE;
    int* protectedBlock = (int*)LocalAlloc(LPTR, (SIZE_T)blockSize);

    protectedBlock[0] = 1234;
    printf("Before encryption: %d\n", protectedBlock[0]);

    CryptProtectMemory(protectedBlock, blockSize, CRYPTPROTECTMEMORY_SAME_PROCESS);
    printf("After encryption: %d\n", protectedBlock[0]);

    CryptUnprotectMemory(protectedBlock, blockSize, CRYPTPROTECTMEMORY_SAME_PROCESS);
    printf("After decryption: %d\n", protectedBlock[0]);

    SecureZeroMemory(protectedBlock, blockSize);
    LocalFree(protectedBlock);

    return 0;
}