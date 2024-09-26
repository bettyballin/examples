csharp
using System;
using System.Text;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string key = "your_base64_encoded_key_here";
        Aes rm = Aes.Create();
        rm.IV = Convert.FromBase64String(ASCIIEncoding.UTF8.GetString(Convert.FromBase64String(key)).Split(',')[0]);
    }
}