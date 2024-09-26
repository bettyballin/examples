csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (var aes = Aes.Create())
        {
            aes.Mode = CipherMode.CBC;
            aes.Padding = PaddingMode.None;
            // Use aes for encryption or decryption
        }
    }
}