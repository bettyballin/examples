csharp
using System;

public enum LoginRole
{
    User = 0,
    Director = 1,
    Admin = 2
}

class Program
{
    static void Main()
    {
        Console.WriteLine(LoginRole.User);
        Console.WriteLine(LoginRole.Director);
        Console.WriteLine(LoginRole.Admin);
    }
}