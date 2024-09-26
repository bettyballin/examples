cpp
#include <Windows.h>
#include <Shellapi.h>
#include <Security.h>

#pragma comment(lib, "shell32.lib")
#pragma comment(lib, "advapi32.lib")

BOOL RunAsAdmin(HWND hWnd, LPCTSTR lpFile, LPCTSTR lpParameters)
{
    SHELLEXECUTEINFO sei;
    ZeroMemory(&sei, sizeof(sei));

    sei.cbSize          = sizeof(SHELLEXECUTEINFOW);
    sei.hwnd            = hWnd;
    sei.fMask           = SEE_MASK_FLAG_DDEWAIT | SEE_MASK_FLAG_NO_UI;
    sei.lpVerb          = _TEXT("runas");
    sei.lpFile          = lpFile;
    sei.lpParameters    = lpParameters;
    sei.nShow           = SW_SHOWNORMAL;

    if (!ShellExecuteEx(&sei)) {
            return FALSE;
    }
    return TRUE;
}

BOOL IsUserAdmin(VOID)
{
    BOOL b;
    SID_IDENTIFIER_AUTHORITY NtAuthority = { SECURITY_NT_AUTHORITY };
    PSID AdministratorsGroup;
    b = AllocateAndInitializeSid(
            &NtAuthority,
            2,
            SECURITY_BUILTIN_DOMAIN_RID,
            DOMAIN_ALIAS_RID_ADMINS,
            0, 0, 0, 0, 0, 0,
            &AdministratorsGroup);
    if (b) {
            if (!CheckTokenMembership( NULL, AdministratorsGroup, &b)) {
                    b = FALSE;
            }
            FreeSid(AdministratorsGroup);
    }

    return b;
}

void DoFormat()
{
    // Implement DoFormat functionality here
    MessageBox(NULL, _TEXT("DoFormat called"), _TEXT("Info"), MB_OK);
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    HWND hwnd = NULL; // Replace with your window handle
    LPCTSTR exeName = _TEXT("YourExeName.exe"); // Replace with your exe name

    if (!IsUserAdmin()) {
        RunAsAdmin(hwnd, exeName, _TEXT("--do-format"));
    } else {
        DoFormat();
    }

    return 0;
}