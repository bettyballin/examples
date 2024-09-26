csharp
using System;
using System.Web.Security;

class Program
{
    static void Main()
    {
        string username = "YourUsername";
        string password = "YourPassword";

        if (Membership.ValidateUser(username, password))
        {
            Console.WriteLine("User is valid");
        }
        else
        {
            Console.WriteLine("User is not valid");
        }
    }
}