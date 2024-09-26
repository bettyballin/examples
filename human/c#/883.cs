csharp
using System;

class Program
{
    public static string Base64Encode(byte[] bytes)
    {
        return System.Convert.ToBase64String(bytes);
    }

    static byte[] GetBytes(string str)
    {
        byte[] bytes = new byte[str.Length * sizeof(char)];
        System.Buffer.BlockCopy(str.ToCharArray(), 0, bytes, 0, bytes.Length);
        return bytes;
    }

    static void Main()
    {
        string input = "Hello, World!";
        byte[] bytes = GetBytes(input);
        string base64Encoded = Base64Encode(bytes);
        Console.WriteLine(base64Encoded);
    }
}