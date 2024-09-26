csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string _key = "your_key_here"; // replace with your key
        byte[] result = Decrypt(_key);
        Console.WriteLine(BitConverter.ToString(result));
    }

    public static byte[] Decrypt(string _key)
    {
        byte[] bytes = StringToByteArray(_key);

        using (DESCryptoServiceProvider cryptoProvider = new DESCryptoServiceProvider())
        {
            cryptoProvider.Padding = PaddingMode.None;
            cryptoProvider.Mode = CipherMode.ECB;

            using (var crypter = cryptoProvider.CreateDecryptor(bytes, new byte[8]))
            {
                return crypter.TransformFinalBlock(bytes, 0, bytes.Length);
            }
        }
    }

    public static byte[] StringToByteArray(string hex)
    {
        return Array.ConvertAll(hex.ToCharArray(), c => (byte)Convert.ToInt32(c.ToString(), 16));
    }
}