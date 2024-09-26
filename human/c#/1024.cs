csharp
using Org.BouncyCastle.Asn1.Sec;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Math.EC;
using Org.BouncyCastle.Utilities.Encoders;

class Program
{
    static void Main()
    {
        X9ECParameters x9Params = SecNamedCurves.GetByName("secp384r1");
        ECPoint ecpoint = x9Params.Curve.DecodePoint(Hex.Decode("03873BE2A6061DA748EDC12609B0705226E041CED7109477E672ECE355181C861C975670372637F96FE9E79CE431E9C54E"));
        byte[] compressed = ecpoint.GetEncoded(true);
        byte[] uncompressed = ecpoint.GetEncoded(false);
        Console.WriteLine(Hex.ToHexString(compressed));   // 03873be2a6061da748edc12609b0705226e041ced7109477e672ece355181c861c975670372637f96fe9e79ce431e9c54e
        Console.WriteLine(Hex.ToHexString(uncompressed)); // 04873be2a6061da748edc12609b0705226e041ced7109477e672ece355181c861c975670372637f96fe9e79ce431e9c54ef91b94e3af12c084dbaf436db786aafc8251f847d604161823fde990730650e3750e980c96d025e9b2ee4d783ff0bf15
    }
}