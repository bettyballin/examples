csharp
using System;
using System.Text;
using System.Diagnostics;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Modes;
using Org.BouncyCastle.Crypto.Parameters;

public class Program
{
    public static string BlowfishDecrypt(string encrypted, string key)
    {
        var cipher = new BufferedBlockCipher(new BlowfishEngine());
        var k = new KeyParameter(Encoding.UTF8.GetBytes(key));
        cipher.Init(false, k);

        var input = Convert.FromBase64String(encrypted);
        var length = cipher.GetOutputSize(input.Length);
        var block = new byte[length];
        var len = cipher.ProcessBytes(input, 0, input.Length, block, 0);
        var output = cipher.DoFinal(block, len);

        var idx = Array.IndexOf(block, (byte)0);
        if (idx != -1)
        {
            return Encoding.UTF8.GetString(block, 0, idx);
        }
        else
        {
            return Encoding.UTF8.GetString(block);
        }
    }

    static string original = "@€~&gt;|";
    static string encrypted_with_utf8_encode = "7+XyF+QGcA8lz5AQlLf1FA==";
    static string encrypted_without = "3oWsAOEF+Kc=";
    static string key = "t0ps3cr3t";

    public static void Main()
    {
        var decrypted1 = BlowfishDecrypt(encrypted_with_utf8_encode, key);
        var decrypted2 = BlowfishDecrypt(encrypted_without, key);
        var same = original.Equals(decrypted1);
        Console.WriteLine("Decrypted 1: " + decrypted1);
        Console.WriteLine("Decrypted 2: " + decrypted2);
        Console.WriteLine("Are they the same? " + same);
    }
}