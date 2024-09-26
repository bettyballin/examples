csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (var aes = Aes.Create())
        {
            aes.Key = new byte[32];
            aes.IV = new byte[16];

            var encryptor = aes.CreateEncryptor(aes.Key, aes.IV);
        }
    }
}