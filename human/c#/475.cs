csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        using (Aes rijMan = Aes.Create())
        {
            rijMan.GenerateIV();
            string ivString = Convert.ToBase64String(rijMan.IV);
            Console.WriteLine(ivString);
        }
    }
}