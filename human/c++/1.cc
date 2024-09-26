cpp
#include <windows.h>
#include <atlsecurity.h>
#include <iostream>

int main()
{
    // Initialize COM
    CoInitialize(NULL);

    // Define folder path
    CString strFolder = "C:\\Path\\To\\Folder";

    // Get the DACL
    CDacl oDacl;
    AtlGetDacl(strFolder, SE_FILE_OBJECT, &oDacl);

    // Remove existing "Users" access
    oDacl.RemoveAces(Sids::Users());

    // Add new "Users" access
    oDacl.AddAllowedAce(Sids::Users(), FILE_ALL_ACCESS, CONTAINER_INHERIT_ACE | OBJECT_INHERIT_ACE);

    // Set the DACL
    AtlSetDacl(strFolder, SE_FILE_OBJECT, oDacl);

    // Uninitialize COM
    CoUninitialize();

    return 0;
}