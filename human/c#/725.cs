csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;
using System.Windows.Forms;

class Program
{
    static void Main()
    {
        string buffer = "your_encrypted_data_here"; // replace with your encrypted data
        DESCryptoServiceProvider desCryptSrvckey = new DESCryptoServiceProvider();
        desCryptSrvckey.Key = Encoding.UTF8.GetBytes("your_key_here"); // replace with your key
        desCryptSrvckey.IV = desCryptSrvckey.Key;

        using (MemoryStream encryptedStream = new MemoryStream(Convert.FromBase64String(buffer)))
        using (CryptoStream cs = new CryptoStream(encryptedStream, desCryptSrvckey.CreateDecryptor(), CryptoStreamMode.Read))
        using (StreamReader sr = new StreamReader(cs))
        {
            string decryptedText = sr.ReadToEnd();
            Console.WriteLine(decryptedText);
        }
    }
}