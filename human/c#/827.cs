csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string algorithm = "AES";
        string keyName = "MyKey";
        string blobType = "PrivateKeyBlob";
        byte[] exported = new byte[] { /* your exported key blob */ };

        var keyParams = new CngKeyCreationParameters();

        keyParams.Properties.Add(new CngProperty(blobType, exported, CngPropertyOptions.None));

        CngKey key = CngKey.Create(algorithm, keyName, keyParams);
    }
}