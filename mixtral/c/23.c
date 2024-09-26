#include <Windows.h>

int main() {
    DWORD dwRawOffset = 0; // replace with actual value
    IMAGE_THUNK_DATA* pThunkData = NULL; // replace with actual value
    IMAGE_SECTION_HEADER* pSectionHeader = NULL; // replace with actual value

    PIMAGE_IMPORT_BY_NAME pImportByName = (PIMAGE_IMPORT_BY_NAME)(dwRawOffset +
                                (pThunkData->u1.AddressOfData -
                                pSectionHeader->VirtualAddress));
    char* name = pImportByName->Name;

    return 0;
}