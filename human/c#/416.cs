csharp
using System;
using WebMatrix.WebData;

public class Program
{
    public static void Main()
    {
        var model = new { UserName = "YourUsername" };
        if (!IsProfileComplete(WebSecurity.GetUserId(model.UserName)))
        {
            Console.WriteLine("Profile is not complete.");
        }
        else
        {
            Console.WriteLine("Profile is complete.");
        }
    }

    public static bool IsProfileComplete(int userId)
    {
        // Your logic to check if the profile is complete
        return true; // or false
    }
}