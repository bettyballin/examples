csharp
using System;
using System.Security.Cryptography;
using System.Linq;

public class Program
{
    public static void Main()
    {
        rsaPlayground();
    }

    public static void rsaPlayground()
    {
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        RSACryptoServiceProvider csp = new RSACryptoServiceProvider();//make a new csp with a new keypair
        var pub_key = csp.ExportParameters(false); // export public key
        var priv_key = csp.ExportParameters(true); // export private key

        var encData = csp.Encrypt(data, false); // encrypt with PKCS#1_V1.5 Padding
        var decBytes = MyRSAImpl.plainDecryptPriv(encData, priv_key); //decrypt with own BigInteger based implementation
        var decData = decBytes.SkipWhile(x => x != 0).Skip(1).ToArray();//strip PKCS#1_V1.5 padding

        Console.WriteLine(BitConverter.ToString(data));
        Console.WriteLine(BitConverter.ToString(encData));
        Console.WriteLine(BitConverter.ToString(decData));
    }
}

public class MyRSAImpl 
{

    private static byte[] rsaOperation(byte[] data, System.Numerics.BigInteger exp, System.Numerics.BigInteger mod)
    {
        System.Numerics.BigInteger bData = new System.Numerics.BigInteger(
            data    //our data block
            .Reverse()  //BigInteger has another byte order
            .Concat(new byte[] { 0 }) // append 0 so we are allways handling positive numbers
            .ToArray() // constructor wants an array
        );
        return 
            System.Numerics.BigInteger.ModPow(bData, exp, mod) // the RSA operation itself
            .ToByteArray() //make bytes from BigInteger
            .Reverse() // back to "normal" byte order
            .ToArray(); // return as byte array

        /*
         * 
         * A few words on Padding:
         * 
         * you will want to strip padding after decryption or apply before encryption 
         * 
         */
    }

    public static byte[] plainEncryptPriv(byte[] data, RSAParameters key) 
    {
        MyRSAParams myKey = MyRSAParams.fromRSAParameters(key);
        return rsaOperation(data, myKey.privExponent, myKey.Modulus);
    }
    public static byte[] plainEncryptPub(byte[] data, RSAParameters key)
    {
        MyRSAParams myKey = MyRSAParams.fromRSAParameters(key);
        return rsaOperation(data, myKey.pubExponent, myKey.Modulus);
    }
    public static byte[] plainDecryptPriv(byte[] data, RSAParameters key)
    {
        MyRSAParams myKey = MyRSAParams.fromRSAParameters(key);
        return rsaOperation(data, myKey.privExponent, myKey.Modulus);
    }
    public static byte[] plainDecryptPub(byte[] data, RSAParameters key)
    {
        MyRSAParams myKey = MyRSAParams.fromRSAParameters(key);
        return rsaOperation(data, myKey.pubExponent, myKey.Modulus);
    }

}

public class MyRSAParams
{
    public static MyRSAParams fromRSAParameters(RSAParameters key)
    {
        var ret = new MyRSAParams();
        ret.Modulus = new System.Numerics.BigInteger(key.Modulus.Reverse().Concat(new byte[] { 0 }).ToArray());
        ret.privExponent = new System.Numerics.BigInteger(key.D.Reverse().Concat(new byte[] { 0 }).ToArray());
        ret.pubExponent = new System.Numerics.BigInteger(key.Exponent.Reverse().Concat(new byte[] { 0 }).ToArray());

        return ret;
    }
    public System.Numerics.BigInteger Modulus;
    public System.Numerics.BigInteger privExponent;
    public System.Numerics.BigInteger pubExponent;
}