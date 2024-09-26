csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        using (Rijndael rijndael = Rijndael.Create())
        {
            byte[] key = Encoding.UTF8.GetBytes("YourKey12345678");
            byte[] iv = Encoding.UTF8.GetBytes("YourIV12345678");

            rijndael.Key = key;
            rijndael.IV = iv;

            ICryptoTransform decryptor = rijndael.CreateDecryptor(rijndael.Key, rijndael.IV);
        }
    }
}