csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Runtime.InteropServices.WindowsRuntime;

public class Program
{
    public static byte[] HmacSha1Sign(byte[] keyBytes, string message)
    {
        var messageBytes = Encoding.UTF8.GetBytes(message);
        using (var hmacsha1 = new HMACSHA1(keyBytes))
        {
            var buffHMAC = hmacsha1.ComputeHash(messageBytes);
            return buffHMAC;
        }
    }

    public static void Main()
    {
        byte[] keyBytes = Encoding.UTF8.GetBytes("YourKeyHere");
        string message = "YourMessageHere";
        byte[] signedBytes = HmacSha1Sign(keyBytes, message);
        Console.WriteLine(BitConverter.ToString(signedBytes));
    }
}