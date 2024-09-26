csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        // Load certificate
        X509Certificate2 x509Certificate = new X509Certificate2("path_to_your_certificate.pfx", "password");

        byte[] pkcs8PrivateKey;

        using (RSA privateKey = x509Certificate.GetRSAPrivateKey())
        {
            pkcs8PrivateKey = ExportPrivateKey(privateKey);
        }

        File.WriteAllText(
            "tls.cer",
            new string(PemEncoding.Write("CERTIFICATE", x509Certificate.RawData)));

        File.WriteAllText(
            "tls.key",
            new string(PemEncoding.Write("PRIVATE KEY", pkcs8PrivateKey)));
    }

    private static byte[] ExportPrivateKey(RSA privateKey)
    {
        try
        {
            // If it's plaintext exportable, just do the easy thing.
            return privateKey.ExportPkcs8PrivateKey();
        }
        catch (CryptographicException)
        {
        }

        using (RSA exportRewriter = RSA.Create())
        {
            // Only one KDF iteration is being used here since it's immediately being
            // imported again.  Use more if you're actually exporting encrypted keys.
            exportRewriter.ImportEncryptedPkcs8PrivateKey(
                "password",
                privateKey.ExportEncryptedPkcs8PrivateKey(
                    "password",
                    new PbeParameters(
                        PbeEncryptionAlgorithm.Aes128Cbc,
                        HashAlgorithmName.SHA256,
                        1)),
                out _);

            return exportRewriter.ExportPkcs8PrivateKey();
        }
    }
}

public static class PemEncoding
{
    public static string Write(string label, byte[] bytes)
    {
        StringBuilder sb = new StringBuilder();
        sb.AppendFormat("-----BEGIN {0}-----\n", label);
        sb.AppendFormat(Convert.ToBase64String(bytes, Base64FormattingOptions.InsertLineBreaks));
        sb.AppendFormat("\n-----END {0}-----\n", label);
        return sb.ToString();
    }
}