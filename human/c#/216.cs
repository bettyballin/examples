csharp
using System;
using System.Security.Principal;
using System.Runtime.InteropServices;
using System.Security.Permissions;

class Program
{
    [DllImport("advapi32.dll", SetLastError = true, CharSet = CharSet.Unicode)]
    static extern bool LogonUser(string lpszUsername, string lpszDomain, string lpszPassword, int dwLogonType, int dwLogonProvider, out IntPtr phToken);

    [DllImport("kernel32.dll")]
    static extern bool CloseHandle(IntPtr hObject);

    static void Main(string[] args)
    {
        AppDomain.CurrentDomain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal);

        if (args.Length != 3)
        {
            Console.WriteLine("Usage: program.exe <username> <password> <file>");
            return;
        }

        string username = args[0];
        string password = args[1];
        string file = args[2];

        IntPtr token;
        if (LogonUser(username, null, password, 9, 0, out token))
        {
            try
            {
                WindowsIdentity idnt = new WindowsIdentity(token);
                WindowsImpersonationContext context = idnt.Impersonate();

                try
                {
                    File.Move(file, "\\\\Server\\Folder");
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
                finally
                {
                    context.Undo();
                }
            }
            finally
            {
                CloseHandle(token);
            }
        }
        else
        {
            Console.WriteLine("Logon failed.");
        }
    }
}