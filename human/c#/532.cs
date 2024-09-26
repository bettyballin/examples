csharp
using System;
using System.Runtime.InteropServices;
using System.Security;

class Program
{
    [DllImport("advapi32.dll", SetLastError = true, CharSet = CharSet.Unicode)]
    internal static extern bool LogonUser(String username, String domain,
                                          IntPtr password, int logonType,
                                          int logonProvider, ref IntPtr token);

    [DllImport("kernel32.dll")]
    internal static extern bool CloseHandle(IntPtr hObject);

    const int LOGON32_LOGON_INTERACTIVE = 2;
    const int LOGON32_PROVIDER_DEFAULT = 0;

    static void Main()
    {
        string userName = "username";
        string domainName = "domain";
        SecureString password = new SecureString();

        // Initialize password
        foreach (char c in "password")
        {
            password.AppendChar(c);
        }

        IntPtr tokenHandle = IntPtr.Zero;
        IntPtr passwordPtr = IntPtr.Zero;

        try
        {
            // Marshal the SecureString to unmanaged memory.
            passwordPtr = Marshal.SecureStringToGlobalAllocUnicode(password);

            bool returnValue = LogonUser(userName, domainName, passwordPtr,
                                        LOGON32_LOGON_INTERACTIVE,
                                        LOGON32_PROVIDER_DEFAULT, ref tokenHandle);

            Console.WriteLine("LogonUser result: " + returnValue);
        }
        finally
        {
            // Zero-out and free the unmanaged string reference.
            Marshal.ZeroFreeGlobalAllocUnicode(passwordPtr);

            // Close the token handle.
            CloseHandle(tokenHandle);

            // Dispose the SecureString
            password?.Dispose();
        }
    }
}