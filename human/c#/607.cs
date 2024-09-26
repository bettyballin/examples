csharp
using System;

[Serializable]
public class Credentials
{
    public string Email { get; set; }
    public string Password { get; set; }
}

class Program
{
    static void Main()
    {
        Credentials credentials = new Credentials();
        credentials.Email = "example@example.com";
        credentials.Password = "password123";

        Console.WriteLine("Email: " + credentials.Email);
        Console.WriteLine("Password: " + credentials.Password);
    }
}