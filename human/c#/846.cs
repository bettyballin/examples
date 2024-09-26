csharp
using System;
using System.IO;
using System.Linq;

class Program
{
    static bool Match(string newPassword)
    {
        var passwords = File.ReadAllLines("passwords.lst");
        return passwords.Any(x => x == newPassword);
    }

    static void Main()
    {
        Console.Write("Enter a password: ");
        string newPassword = Console.ReadLine();
        if (Match(newPassword))
        {
            Console.WriteLine("Password is already in the list.");
        }
        else
        {
            Console.WriteLine("Password is not in the list.");
        }
    }
}