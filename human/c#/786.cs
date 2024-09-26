csharp
using System;
using System.Runtime.InteropServices;
using System.Security.Principal;

public class ImpersonatedUser : IDisposable
{
    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern bool LogonUser(string lpszUsername, string lpszDomain, string lpszPassword, int dwLogonType, int dwLogonProvider, ref IntPtr phToken);

    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern bool ImpersonateLoggedOnUser(IntPtr hToken);

    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern bool RevertToSelf();

    [DllImport("kernel32.dll", SetLastError = true)]
    private static extern bool CloseHandle(IntPtr hObject);

    private IntPtr handle;
    private WindowsImpersonationContext impersonationContext;

    public ImpersonatedUser(string login, string domain, string password)
    {
        if (!LogonUser(login, domain, password, 9, 0, ref handle))
            throw new Exception("Logon failed");

        impersonationContext = WindowsIdentity.Impersonate(handle);
    }

    public void Dispose()
    {
        if (impersonationContext != null)
        {
            impersonationContext.Undo();
            impersonationContext = null;
        }

        if (handle != IntPtr.Zero)
        {
            CloseHandle(handle);
            handle = IntPtr.Zero;
        }
    }
}

class Program
{
    static void Main()
    {
        using (var i = new ImpersonatedUser("someLogin", "someDomain", "thePassword"))
        {
            var u = System.Environment.UserName;
            Console.WriteLine(u);
        }
    }
}