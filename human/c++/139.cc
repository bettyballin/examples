cpp
#include <Windows.h>
#include <winternl.h>
#include <iostream>

using namespace std;

ULONG CheckASLR(ULONG dwProcessId, BOOLEAN& bASLR)
{
    if (HANDLE hProcess = OpenProcess(PROCESS_QUERY_LIMITED_INFORMATION, FALSE, dwProcessId))
    {
        SECTION_IMAGE_INFORMATION sii;

        NTSTATUS status = NtQueryInformationProcess(hProcess, ProcessImageInformation, &sii, sizeof(sii), 0);

        CloseHandle(hProcess);

        if (0 <= status)
        {
            bASLR = sii.ImageDynamicallyRelocated;

            return NOERROR;
        }

        return RtlNtStatusToDosError(status);
    }

    return GetLastError();
}

int main()
{
    ULONG dwProcessId;
    BOOLEAN bASLR;

    cout << "Enter process ID: ";
    cin >> dwProcessId;

    ULONG result = CheckASLR(dwProcessId, bASLR);

    if (result == NOERROR)
    {
        if (bASLR)
        {
            cout << "ASLR is enabled for process " << dwProcessId << endl;
        }
        else
        {
            cout << "ASLR is not enabled for process " << dwProcessId << endl;
        }
    }
    else
    {
        cout << "Failed to check ASLR for process " << dwProcessId << ". Error code: " << result << endl;
    }

    return 0;
}