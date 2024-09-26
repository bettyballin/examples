csharp
using System;
using System.DirectoryServices.AccountManagement;

class Program
{
    static void Main(string[] args)
    {
        string username = "your_username";
        string password = "your_password";

        bool valid = false;
        using (PrincipalContext context = new PrincipalContext(ContextType.Domain))
        {
            valid = context.ValidateCredentials(username, password);
        }

        Console.WriteLine(valid);
    }
}