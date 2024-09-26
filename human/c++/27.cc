cpp
#include <Windows.h>
#include <LsaLookup.h>
#include <string>
#include <iostream>

LSA_UNICODE_STRING toLsaUnicodeString(const std::wstring& str) {
    LSA_UNICODE_STRING lsaWStr;
    DWORD len = 0;

    len = str.length(); 
    LPWSTR cstr = new WCHAR[len + 1];
    memcpy(cstr, str.c_str(), (len + 1) * sizeof(WCHAR));
    lsaWStr.Buffer = cstr;
    lsaWStr.Length = (USHORT)((len) * sizeof(WCHAR));
    lsaWStr.MaximumLength = (USHORT)((len + 1) * sizeof(WCHAR));
    return lsaWStr;
}

int main() {
    std::wstring str = L"Hello, World!";
    LSA_UNICODE_STRING lsaStr = toLsaUnicodeString(str);
    std::wcout << lsaStr.Buffer << std::endl;

    delete[] lsaStr.Buffer; // Don't forget to free the memory!
    return 0;
}