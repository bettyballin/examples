csharp
using System;

public class Program
{
    public static byte[] Pack(string key)
    {
        key = key.Replace("-", "");
        byte[] raw = new byte[key.Length / 2];
        for (int i = 0; i < raw.Length; i++)
        {
            raw[i] = Convert.ToByte(key.Substring(i * 2, 2), 16);
        }
        return raw;
    }

    public static void Main()
    {
        string key = "12-34-56-78-90-AB-CD-EF";
        byte[] packedKey = Pack(key);
        foreach (var b in packedKey)
        {
            Console.Write(b.ToString("X2") + " ");
        }
    }
}