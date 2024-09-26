csharp
using System;

class Program
{
    internal enum KeyBlobMagicNumber : int
    {
        BCRYPT_ECDH_PUBLIC_P256_MAGIC = 0x314B4345,
        BCRYPT_ECDH_PRIVATE_P256_MAGIC = 0x324B4345,
        BCRYPT_ECDH_PUBLIC_P384_MAGIC = 0x334B4345,
        BCRYPT_ECDH_PRIVATE_P384_MAGIC = 0x344B4345,
        BCRYPT_ECDH_PUBLIC_P521_MAGIC = 0x354B4345,
        BCRYPT_ECDH_PRIVATE_P521_MAGIC = 0x364B4345,
        BCRYPT_ECDSA_PUBLIC_P256_MAGIC = 0x31534345,
        BCRYPT_ECDSA_PRIVATE_P256_MAGIC = 0x32534345,
        BCRYPT_ECDSA_PUBLIC_P384_MAGIC = 0x33534345,
        BCRYPT_ECDSA_PRIVATE_P384_MAGIC = 0x34534345,
        BCRYPT_ECDSA_PUBLIC_P521_MAGIC = 0x35534345,
        BCRYPT_ECDSA_PRIVATE_P521_MAGIC = 0x36534345
    }

    static void Main(string[] args)
    {
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDH_PUBLIC_P256_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDH_PRIVATE_P256_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDH_PUBLIC_P384_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDH_PRIVATE_P384_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDH_PUBLIC_P521_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDH_PRIVATE_P521_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDSA_PUBLIC_P256_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDSA_PRIVATE_P256_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDSA_PUBLIC_P384_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDSA_PRIVATE_P384_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDSA_PUBLIC_P521_MAGIC);
        Console.WriteLine(KeyBlobMagicNumber.BCRYPT_ECDSA_PRIVATE_P521_MAGIC);
    }
}