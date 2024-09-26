csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var des = DES.Create();
        var chiper = des.CreateEncryptor(new byte[] { /* your key */ }, new byte[] { /* your IV */ });
    }
}