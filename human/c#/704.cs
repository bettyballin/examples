csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    const string KEY_STRING = "MOGO_APP";

    public static byte[] Decrypt(byte[] encrypt)
    {
        byte[] key = Encoding.ASCII.GetBytes(KEY_STRING);

        DESCryptoServiceProvider cp = new DESCryptoServiceProvider();
        cp.Mode = CipherMode.ECB;
        cp.Key = key;
        ICryptoTransform i = cp.CreateDecryptor();
        return i.TransformFinalBlock(encrypt, 0, encrypt.Length);
    }

    static void Main()
    {
        byte[] encrypt = Encoding.ASCII.GetBytes("your_encrypted_string_here");
        byte[] decrypt = Decrypt(encrypt);
        Console.WriteLine(Encoding.ASCII.GetString(decrypt));
    }
}