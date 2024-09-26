#include <Windows.h>
#include <stdio.h>

int main() {
    // Declarations
    DWORD dwImportDirectoryVA, dwSectionCount, dwSection = 0, dwRawOffset;
    PIMAGE_IMPORT_DESCRIPTOR pImportDescriptor;
    PIMAGE_THUNK_DATA pThunkData, pFTThunkData;

    char* nameArray[100];
    DWORD rvaArray[100];
    int i = 0;

    // Load executable file
    HANDLE hFile = CreateFileA("path_to_your_executable.exe", GENERIC_READ, FILE_SHARE_READ, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
    HANDLE hMap = CreateFileMappingA(hFile, NULL, PAGE_READONLY, 0, 0, NULL);
    LPVOID lpBase = MapViewOfFile(hMap, FILE_MAP_READ, 0, 0, 0);

    // Get NT headers
    PIMAGE_DOS_HEADER pDosHeader = (PIMAGE_DOS_HEADER)lpBase;
    PIMAGE_NT_HEADERS pNtHeaders = (PIMAGE_NT_HEADERS)((LPBYTE)lpBase + pDosHeader->e_lfanew);

    // Import Code
    dwSectionCount = pNtHeaders->FileHeader.NumberOfSections;
    PIMAGE_SECTION_HEADER pSectionHeader = (PIMAGE_SECTION_HEADER)((LPBYTE)pNtHeaders + sizeof(IMAGE_NT_HEADERS));

    for (i = 0; i < dwSectionCount; i++) {
        if (strcmp((char*)pSectionHeader->Name, ".idata") == 0) {
            dwSection = pSectionHeader->VirtualAddress;
            dwRawOffset = pSectionHeader->PointerToRawData;
            break;
        }
        pSectionHeader++;
    }

    pImportDescriptor = (PIMAGE_IMPORT_DESCRIPTOR)((LPBYTE)lpBase + dwRawOffset);

    while (pImportDescriptor->Name != 0) {
        nameArray[i] = (char*)((LPBYTE)lpBase + pImportDescriptor->Name);
        rvaArray[i] = pImportDescriptor->FirstThunk;
        pImportDescriptor++;
        i++;
    }

    // Don't forget to free resources
    UnmapViewOfFile(lpBase);
    CloseHandle(hMap);
    CloseHandle(hFile);

    return 0;
}