csharp
using System;
using System.Runtime.InteropServices;
using System.Security.Principal;
using System.ComponentModel;

public class WindowsAPI
{
    [DllImport("advapi32.dll", SetLastError = true)]
    public static extern bool LogonUser(
        string lpszUsername,
        string lpszDomain,
        string lpszPassword,
        int dwLogonType,
        int dwLogonProvider,
        ref IntPtr phToken
    );

    public const int LOGON32_LOGON_INTERACTIVE = 2;
    public const int LOGON32_PROVIDER_DEFAULT = 0;
}

public class Program
{
    private IntPtr _userToken;
    private string AbbGrainDomain = "your_domain_name"; // replace with your domain name

    private WindowsIdentity GetIdentity(string userName, string password)
    {
        _userToken = IntPtr.Zero;

        if (!WindowsAPI.LogonUser(
            userName,
            AbbGrainDomain,
            password,
            WindowsAPI.LOGON32_LOGON_INTERACTIVE, WindowsAPI.LOGON32_PROVIDER_DEFAULT,
            ref _userToken
        ))
        {
            int errorCode = Marshal.GetLastWin32Error();
            throw new Win32Exception(errorCode);
        }

        return new WindowsIdentity(_userToken);
    }

    public static void Main(string[] args)
    {
        Program program = new Program();
        string userName = "your_user_name"; // replace with your user name
        string password = "your_password"; // replace with your password

        try
        {
            WindowsIdentity identity = program.GetIdentity(userName, password);
            Console.WriteLine(identity.Name);
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }

        Console.ReadKey();
    }
}