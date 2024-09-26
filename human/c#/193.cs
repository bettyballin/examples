csharp
using System;
using System.IO;
using System.Security.Cryptography;

namespace SO6299460
{
    class Program
    {
        static void Main(string[] args)
        {
            GenerateKey();
            string data2Encrypt = string.Empty.PadLeft(128, '$');
            string encrypted = EncryptData(data2Encrypt);
            string decrypted = DecryptData(encrypted);

            Console.WriteLine(data2Encrypt);
            Console.WriteLine(encrypted);
            Console.WriteLine(decrypted);
            Console.ReadLine();
        }

        private const string path = @"c:\";

        public static void GenerateKey()
        {
            RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(2048);
            string publicKey = rsa.ToXmlString(false);
            string privateKey = rsa.ToXmlString(true);

            WriteStringToFile(publicKey, path + "publickey.xml");
            WriteStringToFile(privateKey, path + "privatekey.xml");
        }

        public static void WriteStringToFile(string value, string filename)
        {
            using (FileStream stream = File.Open(filename, FileMode.Create, FileAccess.Write, FileShare.Read))
            using (StreamWriter writer = new StreamWriter(stream))
            {
                writer.Write(value);
                writer.Flush();
                stream.Flush();
            }
        }

        public static string EncryptData(string data2Encrypt)
        {
            RSACryptoServiceProvider rsa = new RSACryptoServiceProvider();
            using (StreamReader reader = new StreamReader(path + "publickey.xml"))
            {
                string publicOnlyKeyXML = reader.ReadToEnd();
                rsa.FromXmlString(publicOnlyKeyXML);
            }

            byte[] plainbytes = System.Text.Encoding.UTF8.GetBytes(data2Encrypt);
            byte[] cipherbytes = rsa.Encrypt(plainbytes, false);

            return Convert.ToBase64String(cipherbytes);
        }

        public static string DecryptData(string data2Decrypt)
        {
            RSACryptoServiceProvider rsa = new RSACryptoServiceProvider();
            using (StreamReader reader = new StreamReader(path + "privatekey.xml"))
            {
                string key = reader.ReadToEnd();
                rsa.FromXmlString(key);
            }

            byte[] cipherbytes = Convert.FromBase64String(data2Decrypt);
            byte[] plainbytes = rsa.Decrypt(cipherbytes, false);
            return System.Text.Encoding.UTF8.GetString(plainbytes);
        }
    }
}