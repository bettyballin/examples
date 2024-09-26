csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string modulusString = "hm2oRCtP6usJKYpq7o1K20uUuL11j5xRrbV4FCQhn/JeXLT21laKK9901P69YUS3bLo64x8G1PkCfRtjbbZCIaa1Ci/BCQX8nF2kZVfrPyzcmeAkq4wsDthuZ+jPInknzUI3TQPAzdj6gim97E731i6WP0MHFqW6ODeQ6Dsp8pc=";
        string publicExponentString = "AQAB";
        string clearTextPassword = "password";

        byte[] modulusBytes = Convert.FromBase64String(modulusString);
        byte[] exponentBytes = Convert.FromBase64String(publicExponentString);

        RSA rsa = RSA.Create();
        rsa.ImportParameters(new RSAParameters
        {
            Modulus = modulusBytes,
            Exponent = exponentBytes
        });

        byte[] plainBytes = Encoding.Unicode.GetBytes(clearTextPassword);
        byte[] cipherData = rsa.Encrypt(plainBytes, RSAEncryptionPadding.Pkcs1);

        string encryptedStringBase64 = Convert.ToBase64String(cipherData);
        Console.WriteLine(encryptedStringBase64);
    }
}