csharp
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;
using System;
using System.IO;
using System.Text;

class Program
{
    static void Main()
    {
        string publicKeyPem = "-----BEGIN PUBLIC KEY-----...-----END PUBLIC KEY-----";
        PemReader pemReader = new PemReader(new StringReader(publicKeyPem));
        RsaKeyParameters publicKeyReloaded = (RsaKeyParameters)pemReader.ReadObject();

        IAsymmetricBlockCipher cipher = new RsaEngine();
        cipher.Init(true, publicKeyReloaded);
        byte[] dataToEncrypt = Encoding.UTF8.GetBytes("Data to encrypt");
        byte[] encryptedData = cipher.ProcessBlock(dataToEncrypt, 0, dataToEncrypt.Length);
        Console.WriteLine(Convert.ToBase64String(encryptedData));
    }
}