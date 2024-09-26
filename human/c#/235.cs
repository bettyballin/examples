csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        using (var rsa = new RSACryptoServiceProvider(2048))
        {
            rsa.FromXmlString(GetKey());

            var data = "Hello, World!";
            var encryptedData = rsa.Encrypt(Encoding.UTF8.GetBytes(data), true);
            var decryptedData = rsa.Decrypt(encryptedData, true);

            Console.WriteLine("Original Data: " + data);
            Console.WriteLine("Encrypted Data: " + Convert.ToBase64String(encryptedData));
            Console.WriteLine("Decrypted Data: " + Encoding.UTF8.GetString(decryptedData));
        }
    }

    static string GetKey()
    {
        return "<RSAKeyValue><Modulus>your_modulus</Modulus><Exponent>your_exponent</Exponent><P>your_p</P><Q>your_q</Q><DP>your_dp</DP><DQ>your_dq</DQ><InverseQ>your_inverse_q</InverseQ><D>your_d</D></RSAKeyValue>";
    }
}