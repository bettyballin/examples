csharp
using System;
using System.IO;
using System.Text;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Encodings;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.OpenSsl;

class Program
{
    static void Main()
    {
        var bytesToDecrypt = Convert.FromBase64String("la0Cz.....D43g==");

        AsymmetricCipherKeyPair keyPair;

        using (var reader = File.OpenText(@"c:\myprivatekey.pem"))
        {
            keyPair = (AsymmetricCipherKeyPair)new PemReader(reader).ReadObject();
        }

        var decryptEngine = new Pkcs1Encoding(new RsaEngine());
        decryptEngine.Init(false, keyPair.Private);

        var decrypted = Encoding.UTF8.GetString(decryptEngine.ProcessBlock(bytesToDecrypt, 0, bytesToDecrypt.Length));

        Console.WriteLine(decrypted);
    }
}