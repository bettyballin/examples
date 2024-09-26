csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] aliceRawKeyAgreement = new byte[32] {
            0xd6, 0xf3, 0x37, 0xd4, 0xc0, 0xd8, 0xe8, 0xbb, 
            0x34, 0x84, 0x8d, 0x4f, 0x0c, 0x1c, 0x68, 0x34, 
            0xf6, 0x6f, 0x69, 0xbb, 0xf9, 0xf2, 0x84, 0xdf, 
            0x5b, 0x87, 0xc7, 0xae, 0xe0, 0x58, 0x4f, 0xc7
        };

        byte[] aliceHashedKeyAgreement = ComputeSha256Hash(aliceRawKeyAgreement);
        string aliceKeyAgreement = BitConverter.ToString(aliceHashedKeyAgreement).Replace("-", "").ToLower();

        byte[] bobRawKeyAgreement = new byte[32] {
            0xd6, 0xf3, 0x37, 0xd4, 0xc0, 0xd8, 0xe8, 0xbb, 
            0x34, 0x84, 0x8d, 0x4f, 0x0c, 0x1c, 0x68, 0x34, 
            0xf6, 0x6f, 0x69, 0xbb, 0xf9, 0xf2, 0x84, 0xdf, 
            0x5b, 0x87, 0xc7, 0xae, 0xe0, 0x58, 0x4f, 0xc7
        };

        byte[] bobHashedKeyAgreement = ComputeSha256Hash(bobRawKeyAgreement);
        string bobKeyAgreement = BitConverter.ToString(bobHashedKeyAgreement).Replace("-", "").ToLower();

        Console.WriteLine("Alice's raw key agreement (BC):        " + BitConverter.ToString(aliceRawKeyAgreement).Replace("-", "").ToLower());
        Console.WriteLine("Alice's hashed key agreement (BC):     " + BitConverter.ToString(aliceHashedKeyAgreement).Replace("-", "").ToLower());
        Console.WriteLine("Alice's key agreement (.NET):          " + aliceKeyAgreement);
        Console.WriteLine();
        Console.WriteLine("Bob's raw key agreement (explicit):    " + BitConverter.ToString(bobRawKeyAgreement).Replace("-", "").ToLower());
        Console.WriteLine("Bob's hashed key agreement (explicit): " + BitConverter.ToString(bobHashedKeyAgreement).Replace("-", "").ToLower());
        Console.WriteLine("Bob's key agreement (.NET):            " + bobKeyAgreement);
    }

    static byte[] ComputeSha256Hash(byte[] bytes)
    {
        using (var sha256 = SHA256.Create())
        {
            return sha256.ComputeHash(bytes);
        }
    }
}