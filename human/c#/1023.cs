csharp
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Utilities.Encoders;
using System;
using System.IO;

class Program
{
    static void Main()
    {
        string x509withUncomp = @"-----BEGIN PUBLIC KEY-----
                        MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEhzvipgYdp0jtwSYJsHBSJuBBztcQlHfm
                        cuzjVRgchhyXVnA3Jjf5b+nnnOQx6cVO+RuU468SwITbr0Ntt4aq/IJR+EfWBBYY
                        I/3pkHMGUON1DpgMltAl6bLuTXg/8L8V
                        -----END PUBLIC KEY-----";
        PemReader pemReaderPrivate = new PemReader(new StringReader(x509withUncomp));
        ECPublicKeyParameters ecPublicParameters = (ECPublicKeyParameters)pemReaderPrivate.ReadObject();
        byte[] compressed = ecPublicParameters.Q.GetEncoded(true);
        byte[] uncompressed = ecPublicParameters.Q.GetEncoded(false);
        Console.WriteLine(Hex.ToHexString(compressed));   
        Console.WriteLine(Hex.ToHexString(uncompressed)); 
    }
}