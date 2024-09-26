csharp
using System;
using System.IO;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        byte[] Data = { 1, 2, 3, 4, 5 };
        ICryptoTransform cryptoTransform = Aes.Create().CreateEncryptor();
        byte[] toReturn;

        using (MemoryStream ms = new MemoryStream())
        {
            using (CryptoStream cs = new CryptoStream(ms, cryptoTransform, CryptoStreamMode.Write))
            {
                cs.Write(Data, 0, Data.Length);
            }

            toReturn = ms.ToArray();
        }

        Console.WriteLine(BitConverter.ToString(toReturn));
    }
}