csharp
using System;
using System.Collections.Generic;
using System.Linq;

public class User
{
    public string Location { get; set; }
}

public class UserManager
{
    public static List<User> Users = new List<User>
    {
        new User { Location = "Mars" },
        new User { Location = "Earth" },
        new User { Location = "Mars" },
    };
}

class Program
{
    static void Main()
    {
        var marsUsers = UserManager.Users.Where(w => w.Location == "Mars").ToList();
        foreach (var user in marsUsers)
        {
            Console.WriteLine(user.Location);
        }
    }
}