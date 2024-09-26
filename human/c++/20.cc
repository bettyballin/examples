cpp
#include <Windows.h>
#include <LsaLookup.h>

typedef struct _POLICY_PRIVILEGE_DEFINITION
{
    LSA_UNICODE_STRING Name;
    LUID LocalValue;
} POLICY_PRIVILEGE_DEFINITION, *PPOLICY_PRIVILEGE_DEFINITION;

int main()
{
    return 0;
}