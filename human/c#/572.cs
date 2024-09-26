csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static byte[] DecryptAES(byte[] toDecryptAES, byte[] AESKeyAndIV, RSAParameters RSAPrivateKey)
    {
        byte[] AESKey = RSADecrypt(AESKeyAndIV, RSAPrivateKey);

        using (MemoryStream source = new MemoryStream(toDecryptAES))
        {
            using (RijndaelManaged AES = new RijndaelManaged())
            {
                AES.KeySize = 256;
                AES.BlockSize = 128;
                AES.Key = AESKey;
                var iv = ReadFully(source, AES.BlockSize / 8); // Changed from KeySize to BlockSize
                AES.IV = iv;
                AES.Mode = CipherMode.CBC;

                using (var cs = new CryptoStream(source, AES.CreateDecryptor(), CryptoStreamMode.Read))
                {
                    using (var dest = new MemoryStream())
                    {
                        cs.CopyTo(dest);
                        return dest.ToArray();
                    }
                }
            }
        }
    }

    public static byte[] RSADecrypt(byte[] data, RSAParameters privateKey)
    {
        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())
        {
            rsa.ImportParameters(privateKey);
            return rsa.Decrypt(data, false);
        }
    }

    public static byte[] ReadFully(Stream stream, int length)
    {
        byte[] buffer = new byte[length];
        int bytesRead = stream.Read(buffer, 0, length);
        if (bytesRead != length)
        {
            throw new IOException("Not enough data in stream");
        }
        return buffer;
    }

    public static void Main()
    {
        // Example usage:
        RSAParameters privateKey = new RSAParameters();
        // Initialize privateKey...

        byte[] AESKeyAndIV = new byte[256 / 8 + 128 / 8]; // 256-bit key and 128-bit IV
        // Initialize AESKeyAndIV...

        byte[] toDecryptAES = new byte[1024]; // Example data to decrypt
        // Initialize toDecryptAES...

        byte[] decrypted = DecryptAES(toDecryptAES, AESKeyAndIV, privateKey);
        Console.WriteLine(BitConverter.ToString(decrypted));
    }
}