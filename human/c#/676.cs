csharp
using System;
using System.IO;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        SHA1 sha1 = SHA1.Create();
        FileStream fs = new FileStream("myFile", FileMode.Open, FileAccess.Read);
        byte[] hash = sha1.ComputeHash(fs);
        fs.Close();

        Console.WriteLine(BitConverter.ToString(hash).Replace("-", "").ToLower());
    }
}