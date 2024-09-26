csharp
using System;
using System.Linq;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] macKey = Encoding.UTF8.GetBytes("macKey");
        byte[] iv = Encoding.UTF8.GetBytes("iv");
        byte[] file = Encoding.UTF8.GetBytes("file");
        byte[] mac = Encoding.UTF8.GetBytes("mac");

        HMACSHA256 hmac = new HMACSHA256(macKey);

        byte[] ivFile = new byte[iv.Length + file.Length];
        Array.Copy(iv, 0, ivFile, 0, iv.Length);
        Array.Copy(file, 0, ivFile, iv.Length, file.Length);

        byte[] macCalc = hmac.ComputeHash(ivFile);

        byte[] macCalc10 = new byte[10];
        Array.Copy(macCalc, 0, macCalc10, 0, Math.Min(10, macCalc.Length));

        bool verified = macCalc10.SequenceEqual(mac.Take(Math.Min(10, mac.Length)));

        Console.WriteLine(verified);
    }
}