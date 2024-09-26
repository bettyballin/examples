csharp
using System;
using System.Security.Cryptography;

public class EcKeyStructure
{
    public static void Main()
    {
        // Define the private key value (32 bytes)
        byte[] privateKey = new byte[32];

        // Define the public key value (65 bytes, with leading 0x04 byte)
        byte[] publicKey = new byte[65];

        // Define the EC key structure
        byte[] ecKeyStructure = new byte[]
        {
            0x30, 0x77, // SEQUENCE (119 bytes)
            0x02, 0x01, 0x00, // INTEGER 0 (version of PKCS#8 structure)
            0x30, 0x13, // SEQUENCE (19 bytes)
            0x06, 0x07, 0x2a, 0x86, 0x48, 0xce, 0x3d, 0x02, 0x01, // OBJECT IDENTIFIER 1.2.840.10045.2.1 (EC key)
            0x06, 0x08, 0x2a, 0x86, 0x48, 0xce, 0x3d, 0x03, 0x01, 0x07, // OBJECT IDENTIFIER 1.2.840.10045.3.1.7 (secp256r1)
            0x04, 0x41, // OCTET STRING (65 bytes)
            0x30, 0x3d, // SEQUENCE (61 bytes)
            0x02, 0x01, 0x01, // INTEGER 1 (version)
            0x04, 0x20, // OCTET STRING (32 bytes)
            // Private key value (32 bytes)
            privateKey[0], privateKey[1], privateKey[2], privateKey[3],
            privateKey[4], privateKey[5], privateKey[6], privateKey[7],
            privateKey[8], privateKey[9], privateKey[10], privateKey[11],
            privateKey[12], privateKey[13], privateKey[14], privateKey[15],
            privateKey[16], privateKey[17], privateKey[18], privateKey[19],
            privateKey[20], privateKey[21], privateKey[22], privateKey[23],
            privateKey[24], privateKey[25], privateKey[26], privateKey[27],
            privateKey[28], privateKey[29], privateKey[30], privateKey[31],
            0xa1, 0x23, // [1] (35 bytes)
            0x03, 0x21, 0x00, // BIT STRING (33 bytes)
            0x04, // Leading 0x04 byte
            // Public key value (32 bytes)
            publicKey[1], publicKey[2], publicKey[3], publicKey[4],
            publicKey[5], publicKey[6], publicKey[7], publicKey[8],
            publicKey[9], publicKey[10], publicKey[11], publicKey[12],
            publicKey[13], publicKey[14], publicKey[15], publicKey[16],
            publicKey[17], publicKey[18], publicKey[19], publicKey[20],
            publicKey[21], publicKey[22], publicKey[23], publicKey[24],
            publicKey[25], publicKey[26], publicKey[27], publicKey[28],
            publicKey[29], publicKey[30], publicKey[31], publicKey[32]
        };

        Console.WriteLine(BitConverter.ToString(ecKeyStructure));
    }
}