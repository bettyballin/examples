csharp
using System;
using System.Security.Principal;

public class Program
{
    public static void Main()
    {
        var user = WindowsIdentity.GetCurrent();
        CheckIfImAdmin(user);
    }

    public static void CheckIfImAdmin(WindowsIdentity user)
    {
        var principal = new WindowsPrincipal(user);
        if (principal.IsInRole(WindowsBuiltInRole.Administrator))
        {
            Console.WriteLine("You are an administrator.");
        }
        else
        {
            Console.WriteLine("You are not an administrator.");
        }
    }
}