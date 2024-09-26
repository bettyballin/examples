csharp
using System;
using System.Security.Permissions;

class Program
{
    [PrincipalPermission(SecurityAction.Demand, Authenticated = true)]
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
    }
}