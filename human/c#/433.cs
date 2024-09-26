csharp
using System;
using System.Security.Cryptography;

public class Program
{
    private static readonly X509Store keystore = new X509Store(StoreName.My, StoreLocation.CurrentUser);

    public static byte[] GetPublicKey()
    {
        try
        {
            keystore.Open(OpenFlags.ReadOnly);
            X509Certificate2 certificate = keystore.Certificates.Find(X509FindType.FindBySubjectName, "alias", false)[0];
            RSAPublicKey key = (RSAPublicKey)certificate.GetRSAPublicKey();
            return key.ExportParameters(false).Modulus;

        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
        }
        finally
        {
            keystore.Close();
        }
        return null;
    }

    public static void Main(string[] args)
    {
        byte[] publicKey = GetPublicKey();
        if (publicKey != null)
        {
            Console.WriteLine(BitConverter.ToString(publicKey));
        }
    }
}