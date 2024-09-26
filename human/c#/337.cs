csharp
using System.Collections.Generic;
using System.Linq;

public class User
{
    public bool IsAdmin { get; set; }
    public string ManagerId { get; set; }
    public string Id { get; set; }
}

public class UserService
{
    private List<User> _users = new List<User>();

    public IEnumerable<User> GetUsers(User requestingUser)
    {
        if (requestingUser.IsAdmin)
        {
            return _users;
        }

        return _users.Where(u => u.ManagerId == requestingUser.Id);
    }
}

class Program
{
    static void Main(string[] args)
    {
        UserService userService = new UserService();

        User adminUser = new User { IsAdmin = true, Id = "1" };
        User managerUser = new User { IsAdmin = false, Id = "2" };
        User regularUser = new User { IsAdmin = false, Id = "3", ManagerId = "2" };

        userService._users.Add(adminUser);
        userService._users.Add(managerUser);
        userService._users.Add(regularUser);

        var users = userService.GetUsers(adminUser);
        foreach (var user in users)
        {
            System.Console.WriteLine(user.Id);
        }

        users = userService.GetUsers(managerUser);
        foreach (var user in users)
        {
            System.Console.WriteLine(user.Id);
        }
    }
}