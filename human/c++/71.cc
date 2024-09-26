cpp
#include <Windows.h>
#include <Security.h>

DWORD enable_restore() 
{    
  // This allows us to override security to delete files

  HANDLE token;
  BOOL flag;

  struct {
    DWORD count;
    LUID_AND_ATTRIBUTES privilege;
  } token_privileges;

  token_privileges.count = 1;
  token_privileges.privilege.Attributes = SE_PRIVILEGE_ENABLED;

  flag = LookupPrivilegeValue(0, SE_RESTORE_NAME, &token_privileges.privilege.Luid);
  if (!flag) return GetLastError();

  flag = OpenProcessToken(GetCurrentProcess(), TOKEN_ADJUST_PRIVILEGES, &token);
  if (!flag) return GetLastError();

  flag = AdjustTokenPrivileges(token, 0, (PTOKEN_PRIVILEGES)&token_privileges, 0, 0, 0);
  if (!flag) return GetLastError();

  return 0;    
}

int main()
{
    enable_restore();
    return 0;
}