csharp
using System;
using System.Linq;
using System.Text;
using Org.BouncyCastle.Asn1;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.Crypto.Modes;
using Org.BouncyCastle.Crypto.Paddings;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Security;

public class Program
{
    public static string Decrypt(string cipher, string password)
    {
        const int saltLength = 16;
        const int iterations = 1000;
        const string algSpec = "AES/CBC/NoPadding";
        const string algName = "PBEWITHSHA256AND128BITAES-CBC-BC";

        byte[] cipherBytes = Convert.FromBase64String(cipher);
        byte[] saltBytes = cipherBytes.Take(saltLength).ToArray();
        byte[] encryptedBytes = cipherBytes.Skip(saltLength).ToArray();
        char[] passwordChars = password.ToCharArray();

        Asn1Encodable defParams = PbeUtilities.GenerateAlgorithmParameters(algName, saltBytes, iterations);
        IWrapper wrapper = WrapperUtilities.GetWrapper(algSpec);
        ICipherParameters parameters = PbeUtilities.GenerateCipherParameters(algName, passwordChars, defParams);
        wrapper.Init(false, parameters);

        byte[] keyText = wrapper.Unwrap(encryptedBytes, 0, encryptedBytes.Length);

        return Encoding.Default.GetString(keyText);
    }

    public static void Main()
    {
        string cipher = "your_base64_cipher_text";
        string password = "your_password";

        string decrypted = Decrypt(cipher, password);
        Console.WriteLine(decrypted);
    }
}