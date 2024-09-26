csharp
using System;
using System.Security.Cryptography;

public class Program
{
    private const int PROV_RSA_FULL = 1;
    private const int PROV_RSA_SCHANNEL = 12;

    public static void Main()
    {
        var csp = new RSACryptoServiceProvider(2048);
        var data = System.Text.Encoding.UTF8.GetBytes("Hello, World!");
        var signature = SignData(csp, data);
        Console.WriteLine(BitConverter.ToString(signature));
    }

    public static byte[] SignData(RSACryptoServiceProvider csp, byte[] bytes)
    {
        byte[] sig = null;
        if ((csp.CspKeyContainerInfo.ProviderType == PROV_RSA_FULL || csp.CspKeyContainerInfo.ProviderType == PROV_RSA_SCHANNEL) && !csp.CspKeyContainerInfo.HardwareDevice)
        {
            var cspParameters = new CspParameters
            {
                KeyContainerName = csp.CspKeyContainerInfo.KeyContainerName,
                KeyNumber = csp.CspKeyContainerInfo.KeyNumber == KeyNumber.Exchange ? 1 : 2,
            };
            using (var csp2 = new RSACryptoServiceProvider(cspParameters))
            {
                sig = csp2.SignData(bytes, CryptoConfig.MapNameToOID("SHA256"));
            }
        }
        else
        {
            sig = csp.SignData(bytes, CryptoConfig.MapNameToOID("SHA256"));
        }
        return sig;
    }
}