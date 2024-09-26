#include <Windows.h>
#include <Security.h>

int main() {
    PSECURITY_DESCRIPTOR pSD = NULL;
    EXPLICIT_ACCESS ea[1];
    SID_IDENTIFIER_AUTHORITY SIDAuthWorld = SECURITY_WORLD_SID_AUTHORITY;
    PSID EveryoneSid = NULL;
    DWORD dwRes;
    PACL pDacl = NULL;
    SECURITY_DESCRIPTOR sd;

    EveryoneSid = (PSID)LocalAlloc(LPTR, sizeof(SID));
    InitializeSecurityDescriptor(&sd, SECURITY_DESCRIPTOR_REVISION);

    if (!IsValidSid(EveryoneSid)) {
        if(!AllocateAndInitializeSid(&SIDAuthWorld, 1, SECURITY_WORLD_RID,
            0, 0, 0, 0, 0, 0, 0, &EveryoneSid)){
            // Handle error
            return 1;
        }
    }

    ZeroMemory(&ea, sizeof(EXPLICIT_ACCESS));

    // Set up the ACE for Everyone
    ea[0].grfAccessPermissions = GENERIC_ALL;
    ea[0].grfAccessMode = SET_ACCESS;
    ea[0].grfInheritance= NO_INHERITANCE;
    ea[0].Trustee.pMultipleTrustee = NULL;
    ea[0].Trustee.MultipleTrusteeOperation = NO_MULTIPLE_TRUSTEE;
    ea[0].Trustee.TrusteeForm = TRUSTEE_IS_SID;
    ea[0].Trustee.ptstrName  = (LPTSTR) EveryoneSid;

    // Add the ACE to the DACL
    dwRes=SetEntriesInAcl(1, ea, NULL, &pDacl);

    if (ERROR_SUCCESS != dwRes){
        // Handle error
        return 1;
    }

    // Initialize a new security descriptor
    InitializeSecurityDescriptor(&sd, SECURITY_DESCRIPTOR_REVISION);
    SetSecurityDescriptorDacl(&sd, TRUE, pDacl, FALSE);

    LocalFree(EveryoneSid);
    LocalFree(pDacl);

    return 0;
}