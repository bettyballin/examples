csharp
using System;
using System.IO;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (var file1 = new FileStream("file1.txt", FileMode.Open))
        using (var file2 = new FileStream("file2.txt", FileMode.Open))
        using (var md5 = MD5.Create())
        using (var sha1 = SHA1.Create())
        {
            byte[] hash1 = md5.ComputeHash(file1);
            byte[] hash2 = md5.ComputeHash(file2);

            file1.Seek(0, SeekOrigin.Begin);
            file2.Seek(0, SeekOrigin.Begin);

            byte[] hash3 = sha1.ComputeHash(file1);
            byte[] hash4 = sha1.ComputeHash(file2);

            Console.WriteLine(BitConverter.ToString(hash1));
            Console.WriteLine(BitConverter.ToString(hash2));
            Console.WriteLine(BitConverter.ToString(hash3));
            Console.WriteLine(BitConverter.ToString(hash4));
        }
    }
}