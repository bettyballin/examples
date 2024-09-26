#include <Windows.h>
#include <Winternl.h>
#include <stdio.h>

void WalkAcl(PACL acl)
{
    if (USHORT AceCount = acl->AceCount)
    {
        union {
            PVOID pv;
            PBYTE pb;
            PACE_HEADER pAceHeader;
            PACCESS_ALLOWED_ACE pAllowedAce;
        };

        pv = acl + 1;

        do 
        {
            UNICODE_STRING usSid;
            switch (pAceHeader->AceType)
            {
            case ACCESS_ALLOWED_ACE_TYPE:
                if (0 <= RtlConvertSidToUnicodeString(&usSid, &pAllowedAce->SidStart, TRUE))
                {
                    DbgPrint("%08x %wZ\n", pAllowedAce->Mask, usSid);
                    RtlFreeUnicodeString(&usSid);
                }
                break;
            }

        } while (pb += pAceHeader->AceSize, --AceCount);
    }
}

int main()
{
    PACL acl;
    // Replace with your own ACL initialization code
    // For demonstration purposes, we'll assume a valid ACL
    acl = (PACL)LocalAlloc(LPTR, sizeof(ACL) + sizeof(ACCESS_ALLOWED_ACE) + sizeof(SID));
    if (acl)
    {
        // Initialize the ACL structure
        acl->AclRevision = ACL_REVISION;
        acl->Sbz1 = 0;
        acl->AclSize = sizeof(ACL) + sizeof(ACCESS_ALLOWED_ACE) + sizeof(SID);
        acl->AceCount = 1;
        acl->Sbz2 = 0;

        // Initialize the ACE
        PACCESS_ALLOWED_ACE ace = (PACCESS_ALLOWED_ACE)((PBYTE)acl + sizeof(ACL));
        ace->Header.AceType = ACCESS_ALLOWED_ACE_TYPE;
        ace->Header.AceFlags = 0;
        ace->Header.AceSize = sizeof(ACCESS_ALLOWED_ACE) + sizeof(SID);
        ace->Mask = FILE_GENERIC_READ | FILE_GENERIC_WRITE | FILE_GENERIC_EXECUTE;

        // Initialize the SID
        PSID sid = (PSID)((PBYTE)ace + sizeof(ACCESS_ALLOWED_ACE));
        sid->Revision = 1;
        sid->SubAuthorityCount = 1;
        sid->IdentifierAuthority.Value[5] = 5;
        sid->SubAuthority[0] = 18;

        WalkAcl(acl);
        LocalFree(acl);
    }
    return 0;
}