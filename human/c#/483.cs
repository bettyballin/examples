csharp
using System;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.Crypto.Parameters;

class Program
{
    static void Main()
    {
        byte[] key = new byte[24]; // 24 bytes key for 3DES
        new Random().NextBytes(key); // random key for demonstration purposes

        DesEdeEngine desede = new DesEdeEngine();
        desede.Init(true, new KeyParameter(key));
    }
}