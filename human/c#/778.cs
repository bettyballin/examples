csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var IV = new byte[16];
        using (var rng = RandomNumberGenerator.Create())
        {
            rng.GetBytes(IV);
        }

        var fullCipher = new byte[32];
        using (var rng = RandomNumberGenerator.Create())
        {
            rng.GetBytes(fullCipher);
        }

        var cipher = new byte[fullCipher.Length - IV.Length];

        Buffer.BlockCopy(fullCipher, IV.Length, cipher, 0, fullCipher.Length - IV.Length);

        Console.WriteLine(BitConverter.ToString(cipher));
    }
}