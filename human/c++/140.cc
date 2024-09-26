cpp
#include <Windows.h>
#include <winternl.h>

NTSTATUS CheckASLR(HANDLE hProcess, PVOID hmod, BOOLEAN& bASLR)
{
    static volatile UCHAR guz = 0;

    PVOID stack = alloca(guz);

    SIZE_T cb = 0, rcb = MAX_PATH*sizeof(WCHAR);

    union {
        PVOID buf;
        PUNICODE_STRING ObjectName;
    };

    NTSTATUS status;
    do 
    {
        if (cb < rcb)
        {
            cb = RtlPointerToOffset(buf = alloca(rcb - cb), stack);
        }

        if (0 <= (status = NtQueryVirtualMemory(hProcess, hmod, MemoryMappedFilenameInformation, buf, cb, &rcb)))
        {
            HANDLE hFile, hSection;
            IO_STATUS_BLOCK iosb;

            OBJECT_ATTRIBUTES oa = { sizeof(oa), 0, ObjectName };

            status = NtOpenFile(&hFile, FILE_GENERIC_READ, &oa, &iosb, FILE_SHARE_VALID_FLAGS, FILE_SYNCHRONOUS_IO_NONALERT);

            if (0 <= status)
            {
                status = NtCreateSection(&hSection, SECTION_QUERY, 0, 0, PAGE_READONLY, SEC_IMAGE, hFile);

                NtClose(hFile);

                if (0 <= status)
                {
                    SECTION_IMAGE_INFORMATION sii;

                    status = ZwQuerySection(hSection, SectionImageInformation, &sii, sizeof(sii), 0);

                    NtClose(hSection);

                    if (0 <= status)
                    {
                        bASLR = sii.ImageDynamicallyRelocated;
                    }
                }
            }

            break;
        }

    } while (status == STATUS_BUFFER_OVERFLOW );

    return status;
}

int main()
{
    HANDLE hProcess = GetCurrentProcess();
    PVOID hmod = GetModuleHandle(NULL);
    BOOLEAN bASLR;

    NTSTATUS status = CheckASLR(hProcess, hmod, bASLR);

    if (status == 0)
    {
        printf("ASLR: %d\n", bASLR);
    }
    else
    {
        printf("Error: 0x%x\n", status);
    }

    return 0;
}