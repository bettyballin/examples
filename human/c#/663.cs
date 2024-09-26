csharp
using System;
using Org.BouncyCastle.Asn1;

class Program
{
    static void Main()
    {
        // Replace 'obj' with your actual object
        object obj = // your object here;

        DerSequence publicKeySequence = (DerSequence)obj;

        DerBitString encodedPublicKey = (DerBitString)publicKeySequence[1];
        DerSequence publicKey = (DerSequence)Asn1Object.FromByteArray(encodedPublicKey.GetBytes());

        DerInteger modulus = (DerInteger)publicKey[0];
        DerInteger exponent = (DerInteger)publicKey[1];

        Console.WriteLine("Modulus: " + modulus.GetValue());
        Console.WriteLine("Exponent: " + exponent.GetValue());
    }
}