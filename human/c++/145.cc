cpp
#include <Windows.h>
#include <tchar.h>

int main() {
    TCHAR szPassword[200];
    // ...
    SecureZeroMemory(szPassword, sizeof(szPassword));
    return 0;
}