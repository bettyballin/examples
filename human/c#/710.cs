csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class CryptoAlgorithmFactory
{
    public KeyedHashAlgorithm GetValidationAlgorithm()
    {
        return new HMACSHA256();
    }
}

public class ValidationKey
{
    public byte[] GetKeyMaterial()
    {
        return Encoding.UTF8.GetBytes("validation_key");
    }
}

public class Program
{
    private readonly CryptoAlgorithmFactory _cryptoAlgorithmFactory = new CryptoAlgorithmFactory();
    private readonly ValidationKey _validationKey = new ValidationKey();

    public static void Main(string[] args)
    {
        Program program = new Program();
        byte[] clearData = Encoding.UTF8.GetBytes("Hello, World!");
        byte[] protectedData = program.ProtectData(clearData);
        Console.WriteLine(BitConverter.ToString(protectedData));
    }

    public byte[] ProtectData(byte[] clearData)
    {
        using (Aes encryptionAlgorithm = Aes.Create())
        {
            encryptionAlgorithm.Key = Encoding.UTF8.GetBytes("encryption_key");
            encryptionAlgorithm.GenerateIV();

            using (ICryptoTransform encryptor = encryptionAlgorithm.CreateEncryptor())
            {
                using (MemoryStream memStream = new MemoryStream())
                {
                    memStream.Write(encryptionAlgorithm.IV, 0, encryptionAlgorithm.IV.Length);
                    using (CryptoStream cryptoStream = new CryptoStream(memStream, encryptor, CryptoStreamMode.Write))
                    {
                        cryptoStream.Write(clearData, 0, clearData.Length);
                        cryptoStream.FlushFinalBlock();

                        using (KeyedHashAlgorithm signingAlgorithm = _cryptoAlgorithmFactory.GetValidationAlgorithm())
                        {
                            signingAlgorithm.Key = _validationKey.GetKeyMaterial();

                            byte[] signature = signingAlgorithm.ComputeHash(memStream.GetBuffer(), 0, (int)memStream.Length);
                            memStream.Write(signature, 0, signature.Length);

                            byte[] protectedData = memStream.ToArray();
                            return protectedData;
                        }
                    }
                }
            }
        }
    }
}