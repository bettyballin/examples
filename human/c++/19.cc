cpp
#include <Windows.h>
#include <Ntsecapi.h>

NTSTATUS NTAPI LsaEnumeratePrivileges(
    __in LSA_HANDLE PolicyHandle,
    __inout PLSA_ENUMERATION_HANDLE EnumerationContext,
    __out PVOID *Buffer,
    __in ULONG PreferedMaximumLength,
    __out PULONG CountReturned
) {
    return STATUS_SUCCESS;
}

int main() {
    return 0;
}