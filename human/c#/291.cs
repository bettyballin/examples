csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        CspParameters cp = new CspParameters();
        CspKeyContainerInfo info = new CspKeyContainerInfo(cp);
        string fileName = info.UniqueKeyContainerName;
        Console.WriteLine(fileName);
    }
}