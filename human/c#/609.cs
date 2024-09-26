csharp
using System;
using System.IO;
using System.Text;
using System.Xml.Serialization;

public class Credentials
{
    public string Username { get; set; }
    public string Password { get; set; }
}

public class AES
{
    public static byte[] AES_Decrypt(byte[] bytesToBeDecrypted, byte[] key)
    {
        // Your AES decryption implementation goes here
        // This is a placeholder, replace it with your actual implementation
        return bytesToBeDecrypted;
    }
}

class Program
{
    static void Main()
    {
        MemoryStream ms = new MemoryStream(AES.AES_Decrypt(File.ReadAllBytes("passwordfile.pwd"), Encoding.UTF8.GetBytes("encryptionkey"))); 
        XmlSerializer xs = new XmlSerializer(typeof(Credentials));
        Credentials c = (Credentials)xs.Deserialize(ms);
        Console.WriteLine(c.Username);
        Console.WriteLine(c.Password);
    }
}