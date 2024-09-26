cpp
#include <Windows.h>

void freeLsaUnicodeString(LSA_UNICODE_STRING& str) {
    delete [] str.Buffer;
    str.Buffer = 0;
    str.Length = 0;
    str.MaximumLength = 0;
}

int main() {
    LSA_UNICODE_STRING str;
    str.Buffer = new WCHAR[10];
    str.Length = 5;
    str.MaximumLength = 10;
    freeLsaUnicodeString(str);
    return 0;
}