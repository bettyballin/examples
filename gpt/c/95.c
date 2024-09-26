pp
#include <windows.h>
#include <sddl.h>
#include <tchar.h>
#include <iostream>

bool GetSIDFromAccountName(LPCTSTR accountName, PSID *sid) {
    DWORD sidSize = 0;
    DWORD domainSize = 0;
    SID_NAME_USE sidUse;
    // First call to LookupAccountName to get the buffer sizes.
    LookupAccountName(NULL, accountName, NULL, &sidSize, NULL, &domainSize, &sidUse);

    if (GetLastError() != ERROR_INSUFFICIENT_BUFFER) {
        std::cerr << "LookupAccountName failed. Error: " << GetLastError() << std::endl;
        return false;
    }

    *sid = (PSID) new BYTE[sidSize];
    LPTSTR domain = new TCHAR[domainSize];

    //
