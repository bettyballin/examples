csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Asn1Object
{
    public static Asn1Object FromByteArray(byte[] bytes)
    {
        return new Asn1Object(bytes);
    }

    private byte[] _bytes;

    public Asn1Object(byte[] bytes)
    {
        _bytes = bytes;
    }
}

class Program
{
    static void Main()
    {
        string stringPublicKey = "your_base64_encoded_public_key_here";
        Asn1Object obj = Asn1Object.FromByteArray(Convert.FromBase64String(stringPublicKey));
    }
}