csharp
using System;

public static class HexConverter
{
    public static byte[] FromHexString(this string str)
    {
        if (str == null)
        {
            throw new ArgumentNullException(nameof(str));
        }

        int NumberChars = str.Length;
        byte[] bytes = new byte[NumberChars / 2];
        for (int i = 0; i < NumberChars; i += 2)
            bytes[i / 2] = Convert.ToByte(str.Substring(i, 2), 16);
        return bytes;
    }
}

class Program
{
    static void Main()
    {
        string hexString = "1234567890abcdef";
        byte[] bytes = hexString.FromHexString();
        foreach (var b in bytes)
        {
            Console.Write(b + " ");
        }
    }
}