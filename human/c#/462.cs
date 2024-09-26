csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        byte[] salt = new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 };
        string password = "Password123";

        AesManaged aesManaged = new AesManaged();
        aesManaged.KeySize = 256;
        aesManaged.BlockSize = 128;

        Rfc2898DeriveBytes keyDerivationFunction = new Rfc2898DeriveBytes(password, salt, 100000);

        byte[] newKey = keyDerivationFunction.GetBytes(aesManaged.KeySize / 8);
        byte[] newIv = keyDerivationFunction.GetBytes(aesManaged.BlockSize / 8);

        ICryptoTransform decryptor = aesManaged.CreateDecryptor(newKey, newIv);
    }
}