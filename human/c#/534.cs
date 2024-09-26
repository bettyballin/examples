csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class RSADecryption
{
    public static void Decrypt(string key, string iv)
    {
        string privateKeyFile = "RSA_Private.xml";
        string privateKey = File.ReadAllText(privateKeyFile);

        RSA rsa = RSA.Create();
        rsa.FromXmlString(privateKey);

        byte[] encryptedKey = Convert.FromBase64String(key);
        byte[] encryptedIV = Convert.FromBase64String(iv);

        byte[] aesKey = rsa.Decrypt(encryptedKey, RSAEncryptionPadding.Pkcs1);
        byte[] aesIV = rsa.Decrypt(encryptedIV, RSAEncryptionPadding.Pkcs1);
    }
}