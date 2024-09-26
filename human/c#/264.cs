csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        RijndaelManaged RMCrypto = new RijndaelManaged();

        //---generate key---
        RMCrypto.GenerateKey();
        byte[] key = RMCrypto.Key;
        Console.WriteLine("Key : " + System.Convert.ToBase64String(key));

        //---generate IV---
        RMCrypto.GenerateIV();
        byte[] IV = RMCrypto.IV;
        Console.WriteLine("IV : " + System.Convert.ToBase64String(IV));

        //---encrypt the string---
        string cipherText = SymmetricEncryption("This is a test string.", key, IV);
        Console.WriteLine("Ciphertext: " + cipherText);

        //---decrypt the string---
        Console.WriteLine("Original string: " + SymmetricDecryption(cipherText, key, IV));
    }

    static string SymmetricEncryption(string str, byte[] key, byte[] IV)
    {
        MemoryStream ms = new MemoryStream();

        try
        {
            RijndaelManaged RMCrypto = new RijndaelManaged();
            CryptoStream cryptStream = new CryptoStream(ms, RMCrypto.CreateEncryptor(key, IV), CryptoStreamMode.Write);
            StreamWriter sWriter = new StreamWriter(cryptStream);
            sWriter.Write(str);
            sWriter.Close();
            cryptStream.Close();
            return System.Convert.ToBase64String(ms.ToArray());
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
            return String.Empty;
        }
    }

    static string SymmetricDecryption(string str, byte[] key, byte[] IV)
    {
        try
        {
            byte[] b = System.Convert.FromBase64String(str);
            MemoryStream ms = new MemoryStream(b);
            RijndaelManaged RMCrypto = new RijndaelManaged();
            CryptoStream cryptStream = new CryptoStream(ms, RMCrypto.CreateDecryptor(key, IV), CryptoStreamMode.Read);
            StreamReader sReader = new StreamReader(cryptStream);
            String s = sReader.ReadToEnd();
            sReader.Close();
            return s;
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
            return String.Empty;
        }
    }
}