csharp
using Org.BouncyCastle.Asn1;
using Org.BouncyCastle.Math;
using Org.BouncyCastle.Utilities.IO.Pem;
using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        string dhParamsPem = @"-----BEGIN DH PARAMETERS-----
MIIBCAKCAQEAnyWVRlZpZ0P6aVzTS25m1SR+HqJAXsGqRhVSPlijljZ+8B/2d1m7
/HlyZIXIkRkgiBvarl7BK95Uj4A34+rabFaab0aukJm8DgI0Za3MuiPG2+1EsZPm
9IQnGo+VRXv/VZ4ooMUmOw/NLU3lJ4P8ViK9R+1e5OnLK3FWxQWFfidAhDnx8Xzc
vp8Y9qR0DuiQQc3cZaS0Ko+LDxqQJkHobsKdpdd2DGxdeRjg4f65j/WVixSEmSyI
rMwDu4svdk7Bjd9cjlSui3mm7Trf1ME0Ox18Ir5FRuzpZvkuD11oDF0fc3A2gCdx
hiuj5z75xtXMGqcTlzMicWTal6MtLfmWCwIBAg==
-----END DH PARAMETERS-----";

        PemReader pemReader = new PemReader(new StringReader(dhParamsPem));
        PemObject pemObject = pemReader.ReadPemObject();
        Asn1Sequence asn1Seq = Asn1Sequence.GetInstance(pemObject.Content);
        BigInteger p = ((DerInteger)asn1Seq[0]).PositiveValue;
        BigInteger g = ((DerInteger)asn1Seq[1]).PositiveValue;

        Console.WriteLine(p);
        Console.WriteLine(g);
    }
}