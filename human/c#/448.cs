Here is the equivalent C# code:

csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Crypto
{
    private static Aes _aes;
    private static byte[] _rawSecretKey = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

    public Crypto(string passphrase)
    {
        byte[] passwordKey = EncodeDigest(passphrase);

        _aes = Aes.Create();
        _aes.Key = passwordKey;
        _aes.IV = _rawSecretKey;
    }

    public string EncryptAsBase64(byte[] clearData)
    {
        byte[] encryptedData = Encrypt(clearData);
        return Convert.ToBase64String(encryptedData);
    }

    public byte[] Encrypt(byte[] clearData)
    {
        ICryptoTransform encryptor = _aes.CreateEncryptor(_aes.Key, _aes.IV);
        return encryptor.TransformFinalBlock(clearData, 0, clearData.Length);
    }

    private byte[] EncodeDigest(string text)
    {
        using (MD5 md5 = MD5.Create())
        {
            return md5.ComputeHash(Encoding.UTF8.GetBytes(text));
        }
    }
}

Note: You should dispose the `Aes` object when it is no longer needed to free up resources. Also, you may want to consider using a more secure way to store and manage your encryption keys.