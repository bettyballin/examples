cpp
#include <ntlsa.h>
#include <Windows.h>

int main()
{
    NTSTATUS status;
    LSA_HANDLE policyHandle;
    LSA_ENUMERATION_HANDLE enumerationContext = 0;
    PPOLICY_PRIVILEGE_DEFINITION buffer;
    ULONG countReturned;
    ULONG i;

    status = LsaOpenPolicy(NULL, &policyHandle, 0, NULL);
    if (!NT_SUCCESS(status))
    {
        return -1;
    }

    while (TRUE)
    {
        status = LsaEnumeratePrivileges(policyHandle, &enumerationContext, &buffer, 256, &countReturned);

        if (status == STATUS_NO_MORE_ENTRIES)
            break; // no more privileges
        if (!NT_SUCCESS(status))
            break; // error

        for (i = 0; i < countReturned; i++)
        {
            // Privilege definition in buffer[i]
            // You can access the privilege name using buffer[i]->Name
            // and the privilege attributes using buffer[i]->Attributes
        }

        LsaFreeMemory(buffer);
    }

    LsaClose(policyHandle);
    return 0;
}