csharp
using System;
using System.Security.Permissions;
using System.Security.Principal;

public class PostBoxData
{
    // Define the PostBoxData class properties and methods here
}

public class Program
{
    [PrincipalPermission(SecurityAction.Demand, Role = "rdm-WEB-Reas_rw")]
    public static string SetBoxPosition(PostBoxData postBoxData)
    {
        // Implement the SetBoxPosition method logic here
        return "Box position set successfully";
    }

    public static void Main(string[] args)
    {
        PostBoxData postBoxData = new PostBoxData();
        try
        {
            string result = SetBoxPosition(postBoxData);
            Console.WriteLine(result);
        }
        catch (SecurityException ex)
        {
            Console.WriteLine("Security exception: " + ex.Message);
        }
    }
}