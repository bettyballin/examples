csharp
using System;
using System.Security.Principal;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine(IsAdministrator());
    }

    public static bool IsAdministrator()
    {
        WindowsIdentity windowsIdentity = WindowsIdentity.GetCurrent();
        WindowsPrincipal windowsPrincipal = new WindowsPrincipal(windowsIdentity);

        return windowsPrincipal.IsInRole(WindowsBuiltInRole.Administrator);
    }
}