csharp
using System;
using System.Security.Cryptography;

public class Program
{
    internal static int NameOrOidToAlgId(string oid, OidGroup oidGroup)
    {
        if (oid == null)
        {
            return 0x8004;
        }
        string str = CryptoConfig.MapNameToOID(oid, oidGroup);
        if (str == null)
        {
            str = oid;
        }
        int algIdFromOid = GetAlgIdFromOid(str, oidGroup);
        switch (algIdFromOid)
        {
            case 0:
            case -1:
                throw new CryptographicException(Environment.GetResourceString("Cryptography_InvalidOID"));
        }
        return algIdFromOid;
    }

    private static int GetAlgIdFromOid(string oid, OidGroup oidGroup)
    {
        // implement this method
        // for demonstration purposes, a simple implementation
        if (oid == "1.2.840.113549.1.1.5")
            return 0x00006611; // RSA
        else
            return -1;
    }

    public static void Main()
    {
        try
        {
            int algId = NameOrOidToAlgId("RSA", OidGroup.PublicKeyAlgorithm);
            Console.WriteLine(algId.ToString("X"));
        }
        catch (CryptographicException ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}