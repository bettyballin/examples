csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        using var ecdh = ECDiffieHellman.Create(ECCurve.CreateFromFriendlyName("brainpoolP256r1"));
        ecdh.GenerateKey(ECDiffieHellmanKeyDerivationFunction.Hash, HashAlgorithmName.SHA256);
        var bobKey = Convert.ToBase64String(ecdh.ExportParameters(false).Q.X.Concat(ecdh.ExportParameters(false).Q.Y).ToArray());
        var bobLength = Convert.FromBase64String(bobKey).Length;

        var alicePublicKey = "RUNLUCAAAAB/xP7JhSIhYIYAijyC2zHu7obB5CwfK/ynQPxcRAIhBI6OLRRcHyPo61AhfSZN3qA2vGDfWO2mrdWWvqqhVaDf";
        var aliceKeyBuffer = Convert.FromBase64String(alicePublicKey);
        var aliceKey = new byte[bobLength];
        Array.Copy(aliceKeyBuffer, 8, aliceKey, 1, aliceKeyBuffer.Length - 8);
        aliceKey[0] = 4;

        var tt = ecdh.DeriveKeyFromHash(aliceKey, HashAlgorithmName.SHA256);
        var bobSecretKey = Convert.ToBase64String(tt);

        Console.WriteLine(bobSecretKey);
    }
}