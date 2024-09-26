csharp
using System;

public class User
{
    private string _password;

    public User(string password)
    {
        _password = password;
    }

    public virtual bool ChangePassword(string oldPassword, string newPassword)
    {
        if (_password == oldPassword)
        {
            _password = newPassword;
            return true;
        }
        return false;
    }
}

class Program
{
    static void Main()
    {
        User user = new User("oldPassword");
        Console.WriteLine(user.ChangePassword("oldPassword", "newPassword"));  // Outputs: True
        Console.WriteLine(user.ChangePassword("oldPassword", "anotherPassword"));  // Outputs: False
    }
}