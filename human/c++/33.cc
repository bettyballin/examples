cpp
#include <Windows.h>
#include <Security.h>

static VOID GetSecAttr(PSECURITY_ATTRIBUTES SecAttr)
{

   LPTSTR sd = L"D:P(A;;GA;;;SY)(A;;GRGWGX;;;BA)(A;;GRGW;;;WD)(A;;GR;;;RC)";

   ZeroMemory(SecAttr, sizeof(SECURITY_ATTRIBUTES));

   ConvertStringSecurityDescriptorToSecurityDescriptor(sd, SDDL_REVISION_1, &SecAttr->lpSecurityDescriptor, NULL);

   SecAttr->nLength = sizeof(SECURITY_ATTRIBUTES);
   SecAttr->bInheritHandle = TRUE;
}

static VOID WINAPI ServiceMain(DWORD dwArgc, LPTSTR *lpszArgv)
{

   SECURITY_ATTRIBUTES sa;
   HANDLE device;

   GetSecAttr(&sa);

   device = CreateFile(
       L"MY_DEVICE_NAME",
       GENERIC_READ | GENERIC_WRITE,
       FILE_SHARE_READ | FILE_SHARE_WRITE,
       &sa,                
       OPEN_EXISTING, 
       FILE_FLAG_OVERLAPPED, 
       NULL);

   if (device == INVALID_HANDLE_VALUE) {
       // handle error
   }
}

int main() {
    SERVICE_TABLE_ENTRY st[] = {
        { L"ServiceName", ServiceMain },
        { NULL, NULL }
    };

    StartServiceCtrlDispatcher(st);
    return 0;
}