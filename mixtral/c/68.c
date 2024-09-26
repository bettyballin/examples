#include <windows.h>
#include <stdio.h>

void GetSidFromAccountName(LPCTSTR szServer, LPCTSTR szUser)
{
    DWORD dwSize = 0;

    // First call to LookupAccountName gets the size of SID
    if (!LookupAccountName(szServer, szUser, NULL, &dwSize, NULL, NULL, NULL))
    {
       DWORD dwError = GetLastError();

       // If error is ERROR_INSUFFICIENT_BUFFER
       if (ERROR_INSUFFICIENT_BUFFER == dwError)
       {
           PSID pSid;

            // Allocate memory for SID
           pSid = (PSID)LocalAlloc(LPTR, dwSize);

          // Second call to LookupAccountName gets the actual SID
         if (LookupAccountName(szServer, szUser, pSid, &dwSize, NULL, NULL, NULL))
            {
               printf("Successfully retrieved SID\n");

           // Do something with PSID here

          }

       LocalFree((HLOCAL)pSid);

      }

   else

    printf("LookupAccountName failed: %ld\n", dwError);

  }

}

int main()
{
    GetSidFromAccountName(NULL, "your_username");
    return 0;
}