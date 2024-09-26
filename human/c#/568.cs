csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class User
{
    public string Username { get; set; }
    public string Salt { get; set; }
    public string HashedPassword { get; set; }
}

public class Program
{
    public static bool Authenticate(string username, string password)
    {
        User user = Users.SelectSingle(x => x.Username.Equals(username));
        string calculatedHash = GeneratePasswordHash(password, user.Salt);
        return user.HashedPassword.Equals(calculatedHash);
    }

    public static string GeneratePasswordHash(string password, string salt)
    {
        using (var sha256 = SHA256.Create())
        {
            var bytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password + salt));
            var builder = new StringBuilder();
            for (var i = 0; i < bytes.Length; i++)
            {
                builder.Append(bytes[i].ToString("x2"));
            }
            return builder.ToString();
        }
    }

    public static User[] Users = new[]
    {
        new User
        {
            Username = "test",
            Salt = "salt",
            HashedPassword = GeneratePasswordHash("password", "salt")
        }
    };

    public static void Main()
    {
        Console.WriteLine(Authenticate("test", "password"));
    }
}