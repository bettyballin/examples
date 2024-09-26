csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        Console.WriteLine(GenerateDsaKeyInDefaultContainer());
    }

    static string GenerateDsaKeyInDefaultContainer()
    {
        const int PROV_DSS_DH = 13;
        CspParameters cspParam = new CspParameters(PROV_DSS_DH);
        cspParam.KeyContainerName = null;
        cspParam.KeyNumber = (int)KeyNumber.Signature;
        cspParam.Flags = CspProviderFlags.UseDefaultKeyContainer;
        DSACryptoServiceProvider csp = new DSACryptoServiceProvider(cspParam);
        return csp.CspKeyContainerInfo.UniqueKeyContainerName;
    }
}