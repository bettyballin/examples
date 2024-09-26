csharp
using System;
using BlowfishNET;

public class Crypter
{
    public class Blowfish
    {
        public static string Crypt(string password, string salt)
        {
            BlowfishEngine engine = new BlowfishEngine();
            engine.Init(true, salt.GetBytes());
            return engine.EncryptString(password);
        }
    }
}

public static class StringExtensions
{
    public static byte[] GetBytes(this string value)
    {
        return System.Text.Encoding.UTF8.GetBytes(value);
    }
}

class Program
{
    static void Main()
    {
        string password = "your_password";
        string salt = "some_SALT";
        string cryptedPassword = Crypter.Blowfish.Crypt(password, salt);
        Console.WriteLine(cryptedPassword);
    }
}