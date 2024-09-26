csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string keyName = "My3DESKey";
        CngKeyCreationParameters keyCreationParameters = new CngKeyCreationParameters();

        CngKey.Create(new CngAlgorithm("3DES"), keyName, keyCreationParameters);
    }
}