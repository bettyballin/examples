
HANDLE hProcess = GetCurrentProcess(); // Handle to the current process
HANDLE hProcessToken;

if (!OpenProcessToken(hProcess, TOKEN_ADJUST_PRIVILEGES, &hProcessToken)) {
    LOG_ERROR(L"Failed to open process token");
    return false;
}

TOKEN_PRIVILEGES tp;
LUID luid;

if (!LookupPrivilegeValue(NULL, SE_TCB_NAME, &luid)) {
    LOG_ERROR(L"Failed to lookup privilege value for SE_TCB_NAME");
    CloseHandle(hProcessToken);
    return false;
}

tp.PrivilegeCount = 1;
tp.Privileges[0].Luid = luid;
tp.Privileges[0].Attributes = SE_PRIVILEGE_ENABLED;

if (!AdjustTokenPrivileges(hProcessToken, FALSE, &
