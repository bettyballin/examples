csharp
using System;

public class Program
{
    public static byte[] StringToByteArray(String hex) 
    {
        int NumberChars = hex.Length;
        byte[] bytes = new byte[NumberChars / 2];
        for (int i = 0; i < NumberChars; i += 2)
            bytes[i / 2] = Convert.ToByte(hex.Substring(i, 2), 16);
        return bytes;
    }

    public static void Main()
    {
        string hex = "48656c6c6f20576f726c64";
        byte[] bytes = StringToByteArray(hex);
        foreach (byte b in bytes)
        {
            Console.Write(b + " ");
        }
    }
}