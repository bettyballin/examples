csharp
using System;
using System.Security.Principal;

public class User
{
    public bool IsInRole(string role)
    {
        // Your role checking logic here
        return true; // For demonstration purposes
    }
}

class Program
{
    static void Main()
    {
        User user = new User();
        if (user.IsInRole("MyDeleteRole"))
        {
            Console.WriteLine("<input type=\"submit\" value=\"Delete\">");
        }
    }
}