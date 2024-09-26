#include <Windows.h>
#pragma comment(lib "sechost.lib")

BOOL GetDefaultChildSecurityDescriptorFromParent(LPSECURITY_DESCRIPTOR Parent, LPSECURITY_DESCRIPTOR* Child)
{
    BOOL result = FALSE;

    // Create a new security descriptor for the child object
    *Child = (PSECURITY_DESCRIPTOR)HeapAlloc(GetProcessHeap(), 0, SECURITY_DESCRIPTOR_MIN_LENGTH);

    if (*Child != NULL)
    {
        // Initialize the child security descriptor with the parent's security descriptor
        result = InitializeSecurityDescriptor(*Child, SECURITY_DESCRIPTOR_REVISION);
        if (result)
        {
            result = SetSecurityDescriptorDacl(*Child, TRUE, NULL, FALSE);
        }

        if (result == FALSE)
        {
            HeapFree(GetProcessHeap(), 0, *Child);
            *Child = NULL;
        }
    }

    return result;
}

int main()
{
    // Create a security descriptor for the parent object
    PSECURITY_DESCRIPTOR Parent = (PSECURITY_DESCRIPTOR)HeapAlloc(GetProcessHeap(), 0, SECURITY_DESCRIPTOR_MIN_LENGTH);

    if (Parent != NULL)
    {
        InitializeSecurityDescriptor(Parent, SECURITY_DESCRIPTOR_REVISION);

        // Get the default child security descriptor
        PSECURITY_DESCRIPTOR Child = NULL;
        if (GetDefaultChildSecurityDescriptorFromParent(Parent, &Child))
        {
            // Use the child security descriptor
            // ...

            // Free the child security descriptor
            HeapFree(GetProcessHeap(), 0, Child);
        }

        // Free the parent security descriptor
        HeapFree(GetProcessHeap(), 0, Parent);
    }

    return 0;
}