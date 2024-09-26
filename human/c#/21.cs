csharp
using System;
using System.Runtime.InteropServices;

class Program
{
    static void Main()
    {
        WindowsAPI.LogonExample();
    }
}

internal class WindowsAPI 
{
    public const int LOGON32_PROVIDER_DEFAULT = 0;
    public const int LOGON32_LOGON_INTERACTIVE = 2;

    [DllImport( "advapi32.dll", SetLastError = true, CharSet = CharSet.Unicode )]
    public static extern bool LogonUser( String lpszUsername, 
        String lpszDomain, String lpszPassword,
        int dwLogonType, int dwLogonProvider, ref IntPtr phToken 
    );

    [DllImport( "kernel32.dll", CharSet = CharSet.Auto )]
    public extern static bool CloseHandle( IntPtr handle );

    public static void LogonExample()
    {
        IntPtr tokenHandle = IntPtr.Zero;
        try
        {
            string userName = "username";
            string domainName = "domain";
            string password = "password";

            bool returnValue = LogonUser(userName, domainName, password,
                LOGON32_LOGON_INTERACTIVE, LOGON32_PROVIDER_DEFAULT,
                ref tokenHandle);

            Console.WriteLine("LogonUser called.");

            if (returnValue)
            {
                Console.WriteLine("The user was logged on successfully.");
            }
            else
            {
                Console.WriteLine("The user was not logged on successfully.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Exception occurred. " + ex.Message);
        }
        finally
        {
            if (tokenHandle != IntPtr.Zero)
            {
                CloseHandle(tokenHandle);
            }
        }
    }
}