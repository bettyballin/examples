csharp
using System;
using System.Diagnostics;
using System.Security;

class Program
{
    static void Main()
    {
        var info = new ProcessStartInfo("shutdown.exe", "/r /t 0");
        info.UserName = "accountWithAdminPermissions";
        var secureString = new SecureString();
        var password = "abc123";
        foreach (var letter in password)
        {
            secureString.AppendChar(letter);
        }
        secureString.MakeReadOnly();
        info.Password = secureString;
        info.UseShellExecute = false;
        var restart = new Process();
        restart.StartInfo = info;
        restart.Start();
    }
}