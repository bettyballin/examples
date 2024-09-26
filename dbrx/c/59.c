#include <Windows.h>
#include <Sddl.h>

#define YOUR_ACCESS_MASK (GENERIC_READ | GENERIC_WRITE)
#define YOUR_SID_STRING L"S-1-1-0" // Everyone SID

bool AceExists(PACL pDacl, PSID pSid)
{
    for (int i = 0; i < pDacl->AceCount; ++i) {
        ACE_HEADER* aceHeader;
        if (!GetAce(pDacl, i, &aceHeader)) {
            return false;
        }
        
        if (aceHeader->AceType == ACCESS_ALLOWED_ACE_TYPE &&
            ((ACCESS_ALLOWED_ACE*)aceHeader)->Mask == YOUR_ACCESS_MASK &&
            EqualSid(&((ACCESS_ALLOWED_ACE*)aceHeader)->SidStart, pSid)) {
                return true;
        }
    }

    return false;
}

void AddAce(PACL* ppDacl)
{
    // Create a new SID for the ACE
    PSID pSid = NULL;
    if (!ConvertStringSidToSid(YOUR_SID_STRING, &pSid)) {
        return;
    }

    if (!AceExists(*ppDacl, pSid)) {
        if (!RtlAddAccessAllowedAce(ppDacl, ACL_REVISION, YOUR_ACCESS_MASK, pSid)) {
            LocalFree(pSid);
            return;
        }
        
        // Update the object's DACL with SetNamedSecurityInfo
        // ...
    }

    LocalFree(pSid);
}

int main()
{
    PACL pDacl = NULL;
    // Initialize pDacl...
    AddAce(&pDacl);
    return 0;
}