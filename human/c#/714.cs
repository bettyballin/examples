csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string key = "your_key_here"; // replace with your key
        string iv = "your_iv_here"; // replace with your iv
        byte[] keybytes = Encoding.UTF8.GetBytes(key);
        byte[] ivbytes = Encoding.UTF8.GetBytes(iv);

        string folderPath = "your_folder_path_here"; // replace with your folder path
        string filename = "your_filename_here"; // replace with your filename
        byte[] cipherText = File.ReadAllBytes(filename);

        string plaintext = Decrypt(cipherText, keybytes, ivbytes);

        string name = filename.Replace(".encrypted", "");
        Mywebservice.Mywebservice dts = new Mywebservice.Mywebservice();
        dts.FileUpload(folderPath, plaintext, name);
    }

    static string Decrypt(byte[] cipherText, byte[] keybytes, byte[] ivbytes)
    {
        using (var rijAlg = new RijndaelManaged())
        {
            rijAlg.Key = keybytes;
            rijAlg.IV = ivbytes;
            var decryptor = rijAlg.CreateDecryptor(rijAlg.Key, rijAlg.IV);
            using (var msDecrypt = new MemoryStream(cipherText))
            {
                using (var csDecrypt = new CryptoStream(msDecrypt, decryptor, CryptoStreamMode.Read))
                {
                    using (var srDecrypt = new StreamReader(csDecrypt))
                    {
                        string plaintext = srDecrypt.ReadToEnd();
                        return plaintext.Substring(23);
                    }
                }
            }
        }
    }
}