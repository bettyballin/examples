csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Threading;

public class Program
{
    public static Tuple<byte[], byte[]> EncryptAES(byte[] toEncryptAES, RSAParameters RSAPublicKey)
    {
        byte[] encryptedAES = null;
        byte[] encryptedRSA = null;

        using (MemoryStream ms = new MemoryStream())
        {
            using (Aes AES = Aes.Create())
            {
                AES.KeySize = 256;
                AES.BlockSize = 128;
                AES.Mode = CipherMode.CBC;
                AES.GenerateIV();
                AES.GenerateKey();
                encryptedRSA = RSAEncrypt(AES.Key, RSAPublicKey);

                ms.Write(AES.IV, 0, AES.IV.Length); 

                using (var cs = new CryptoStream(ms, AES.CreateEncryptor(), CryptoStreamMode.Write))
                {
                    cs.Write(toEncryptAES, 0, toEncryptAES.Length);
                    cs.Close();
                }
                encryptedAES = ms.ToArray();
            }
        }
        return new Tuple<byte[], byte[]>(encryptedAES, encryptedRSA);
    }

    public static byte[] RSAEncrypt(byte[] DataToEncrypt, RSAParameters RSAKeyInfo)
    {
        using (RSACryptoServiceProvider RSA = new RSACryptoServiceProvider())
        {
            RSA.ImportParameters(RSAKeyInfo);
            return RSA.Encrypt(DataToEncrypt, true);
        }
    }

    public static void Main(string[] args)
    {
        RSAParameters rsaKey = GetRsaKey();
        byte[] toEncrypt = System.Text.Encoding.UTF8.GetBytes("Hello, World!");
        var result = EncryptAES(toEncrypt, rsaKey);
        Console.WriteLine(Convert.ToBase64String(result.Item1));
        Console.WriteLine(Convert.ToBase64String(result.Item2));
    }

    private static RSAParameters GetRsaKey()
    {
        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(2048))
        {
            rsa.FromXmlString("<RSAKeyValue><Modulus>your_modulus_here</Modulus><Exponent>your_exponent_here</Exponent></RSAKeyValue>");
            return rsa.ExportParameters(false);
        }
    }
}