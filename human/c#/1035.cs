csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string ciphertext = "P/y3nrZU70XtanEUvubyVUp+LzOVHLGAl55cd+N6T0c9ak15KVXh5UxFEjMYGsvGWzf286wAGc5HgEjmwxWCkdjSt5vt42Anb4jwKlVMdLyYoP9Gg/be";
        Span<byte> encryptedData = Convert.FromBase64String(ciphertext).AsSpan();
        Span<byte> salt = encryptedData[..16]; 
        Span<byte> nonce = encryptedData[16..(16 + 12)];  
        Span<byte> data = encryptedData[(16 + 12)..^16]; 
        Span<byte> tag = encryptedData[^16..];

        string password = "my passphrase";
        using Rfc2898DeriveBytes pbkdf2 = new(Encoding.UTF8.GetBytes(password), salt.ToArray(), 25000, HashAlgorithmName.SHA256); 

        using AesGcm aes = new(pbkdf2.GetBytes(32)); 
        Span<byte> result = new byte[data.Length];
        aes.Decrypt(nonce, data, tag, result);

        Console.WriteLine(Encoding.UTF8.GetString(result)); 
    }
}