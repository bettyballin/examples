#include <Windows.h>
#include <Security.h>
#include <Dbghelp.h>

void WalkAcl(PACL acl)
{
    ACL_SIZE_INFORMATION asi;
    if (GetAclInformation(acl, &asi, sizeof(asi), AclSizeInformation))
    {
        if (asi.AceCount)
        {
            do 
            {
                union {
                    PVOID pvAce;
                    PACE_HEADER pAceHeader;
                    PACCESS_ALLOWED_ACE pAllowedAce;
                };

                PWSTR szSid;
                if (GetAce(acl, --asi.AceCount, &pvAce))
                {
                    switch (pAceHeader->AceType)
                    {
                    case ACCESS_ALLOWED_ACE_TYPE:
                        if (ConvertSidToStringSid(pAllowedAce->SidStart, &szSid))
                        {
                            DbgPrint("%08x %S\n", pAllowedAce->Mask, szSid);
                            LocalFree(szSid);
                        }
                        break;
                    }
                }

            } while (asi.AceCount);
        }
    }
}

int main()
{
    PACL acl;
    // Initialize acl with a valid ACL
    WalkAcl(acl);
    return 0;
}