csharp
using System;
using System.Security;

class Program
{
    static void Main()
    {
        string plainParam = "param you want to encrypt";
        SecureString secureParam = new SecureString();

        foreach (char c in plainParam)
        {
            secureParam.AppendChar(c);
        }

        secureParam.MakeReadOnly();

        Console.WriteLine("Secure parameter created.");
    }
}