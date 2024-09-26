csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        string password = "your_password";
        byte[] bytes = Encoding.ASCII.GetBytes(password.Length.ToString());
        foreach (var b in bytes)
        {
            Console.Write(b + " ");
        }
    }
}