csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string ToHexString(byte[] bytes)
    {
        StringBuilder sb = new StringBuilder(bytes.Length * 2);
        for (int i = 0; i < bytes.Length; ++i)
        {
            sb.Append(string.Format("{0:x2}", bytes[i]));
        }
        return sb.ToString();
    }

    public static void Main(string[] args)
    {
        string str2 = "5f1fa09364a6ae7e35a090b434f182652ab8dd76:{\"expiration\": 1353759442.0991001, \"channel\": \"dreamhacksc2\", \"user_agent\": \".*";
        using (var hmacsha1 = new HMACSHA1(Encoding.UTF8.GetBytes("Wd75Yj9sS26Lmhve")))
        {
            byte[] result = hmacsha1.ComputeHash(Encoding.UTF8.GetBytes(str2));
            string hexString = ToHexString(result);
            Console.WriteLine(hexString);
        }
    }
}