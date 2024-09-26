csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        using (ECDiffieHellman alice = ECDiffieHellman.Create(ECCurve.NamedCurves.brainpoolP256r1))
        {
            var alicePublicKey = Convert.ToBase64String(alice.PublicKey.ToByteArray());
            Console.WriteLine($"Alice's public key: {alicePublicKey}");
            //send alicePublicKey
            var nodejsKey = "your_nodejs_public_key_here"; //NODEJS brainpoolP256r1 publickey  base64
            byte[] nodejsKeyBytes = Convert.FromBase64String(nodejsKey);

            var aliceKey = Convert.ToBase64String(getDeriveKey(nodejsKeyBytes, alice));
            Console.WriteLine($"Derived key: {aliceKey}");

            byte[] encryptedMessage = null;
            byte[] iv = null;
            Send(aliceKey, "Secret message", out encryptedMessage, out iv);

            Console.WriteLine($"Encrypted message: {Convert.ToBase64String(encryptedMessage)}");
            Console.WriteLine($"IV: {Convert.ToBase64String(iv)}");
        }
    }

    static byte[] getDeriveKey(byte[] key1, ECDiffieHellman alice)
    {
        byte[] keyX = new byte[key1.Length / 2];
        byte[] keyY = new byte[keyX.Length];
        Buffer.BlockCopy(key1, 1, keyX, 0, keyX.Length);
        Buffer.BlockCopy(key1, 1 + keyX.Length, keyY, 0, keyY.Length);
        ECParameters parameters = new ECParameters
        {
            Curve = ECCurve.NamedCurves.brainpoolP256r1,
            Q =
            {
                X = keyX,
                Y = keyY,
            },
        };
        byte[] derivedKey;
        using (ECDiffieHellman bob = ECDiffieHellman.Create(parameters))
        using (ECDiffieHellmanPublicKey bobPublic = bob.PublicKey)
        {
            return derivedKey = alice.DeriveKeyFromHash(bobPublic, HashAlgorithmName.SHA256);
        }
    }

    static void Send(string key, string message, out byte[] encryptedMessage, out byte[] iv)
    {
        using (Aes aes = Aes.Create())
        {
            aes.Key = Convert.FromBase64String(key);
            aes.GenerateIV();
            iv = aes.IV;

            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, aes.CreateEncryptor(), CryptoStreamMode.Write))
                {
                    using (StreamWriter sw = new StreamWriter(cs))
                    {
                        sw.Write(message);
                    }
                }

                encryptedMessage = ms.ToArray();
            }
        }
    }
}