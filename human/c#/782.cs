csharp
using System;
using System.IO;

public class Program
{
    public static byte[] HexStringToByteArray(string hexString)
    {
        MemoryStream stream = new MemoryStream(hexString.Length / 2);

        for (int i = 0; i < hexString.Length; i += 2)
        {
            stream.WriteByte(byte.Parse(hexString.Substring(i, 2), System.Globalization.NumberStyles.AllowHexSpecifier));
        }
        return stream.ToArray();
    }

    public static void Main()
    {
        string hexString = "48656c6c6f20576f726c64";
        byte[] byteArray = HexStringToByteArray(hexString);
        foreach (byte b in byteArray)
        {
            Console.Write(b + " ");
        }
    }
}