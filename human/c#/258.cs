csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class RSAEncryption
{
    private string _rsaContainerName = "MyRSAContainer";

    public static void Main(string[] args)
    {
        RSAEncryption rsa = new RSAEncryption();
        string originalValue = "Hello, World!";
        string encryptedValue = rsa.RSAEncrypt(originalValue);
        string decryptedValue = rsa.RSADecrypt(encryptedValue);

        Console.WriteLine("Original Value: " + originalValue);
        Console.WriteLine("Encrypted Value: " + encryptedValue);
        Console.WriteLine("Decrypted Value: " + decryptedValue);
    }

    private string RSAEncrypt(string value)
    {
        byte[] plaintext = Encoding.Unicode.GetBytes(value);

        CspParameters cspParams = new CspParameters();
        cspParams.KeyContainerName = _rsaContainerName;
        using (RSACryptoServiceProvider RSA = new RSACryptoServiceProvider(2048,cspParams))
        {
            byte[] encryptedData = RSA.Encrypt(plaintext, false);
            return Convert.ToBase64String(encryptedData);
        }
    }

    private string RSADecrypt(string value)
    {
        byte[] encryptedData = Convert.FromBase64String(value);

        CspParameters cspParams = new CspParameters();
        cspParams.KeyContainerName = _rsaContainerName;
        using (RSACryptoServiceProvider RSA = new RSACryptoServiceProvider(2048,cspParams))
        { 
            byte[] decryptedData = RSA.Decrypt(encryptedData,false);
            return Encoding.Unicode.GetString(decryptedData);
        }
    }
}