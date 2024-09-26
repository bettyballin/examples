cpp
#include <Windows.h>
#include <tchar.h>

int main() {
    const UINT charcount = 2;
    TCHAR *szPassword = new TCHAR[charcount];
    SecureZeroMemory(szPassword, charcount * sizeof(TCHAR));
    delete[] szPassword;
    return 0;
}