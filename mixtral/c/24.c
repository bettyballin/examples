#include <Windows.h>

int main() {
    IMAGE_IMPORT_DESCRIPTOR* pImportDescritor = NULL;
    IMAGE_THUNK_DATA* pFThunkData = NULL;
    DWORD* rvArray = NULL;
    int i = 0;

    // Assuming you have initialized the above pointers and 'i' correctly

    DWORD rva = (pImportDescritor->FirstThunk +
                 ((char*)&(pFThunkData[i]) -
                  (char*)pImportDescritor));
    rvArray[i] = rva;

    return 0;
}