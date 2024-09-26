csharp
using System;
using System.Security.Permissions;

class Program
{
    [PrincipalPermissionAttribute(SecurityAction.Demand, Role = "Administrator")]
    public static void YourFunction()
    {
        Console.WriteLine("Hello, World!");
    }

    static void Main(string[] args)
    {
        try
        {
            YourFunction();
        }
        catch (SecurityException ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}