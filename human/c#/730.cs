csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

public class AsnKeyParser
{
    private readonly string _fileName;

    public AsnKeyParser(string fileName)
    {
        _fileName = fileName;
    }

    public RSAParameters ParseRSAPublicKey()
    {
        using (var cert = new X509Certificate2(_fileName))
        {
            return cert.GetRSAPublicKey().ExportParameters(false);
        }
    }
}

class Program
{
    private const int PROV_RSA_FULL = 1;
    private const int AT_KEYEXCHANGE = 1;

    static void Main()
    {
        AsnKeyParser keyParser = new AsnKeyParser("rsa-public.der");
        RSAParameters publicKey = keyParser.ParseRSAPublicKey();

        CspParameters csp = new CspParameters
        {
            KeyContainerName = "RSA Test (OK to Delete)",
            ProviderType = PROV_RSA_FULL,    
            KeyNumber = AT_KEYEXCHANGE      
        };

        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(csp))
        {
            rsa.PersistKeyInCsp = false;
            rsa.ImportParameters(publicKey);
        }
    }
}