csharp
using System;
using System.Security.Cryptography;
using System.Text;

internal class HashWrapper
{
    public HashWrapper()
    {
        Value = SHA384.Create();
    }

    public HashAlgorithm Value { get; private set; }
}

class Program
{
    static void Main()
    {
        var hashWrapper = new HashWrapper();
        var data = Encoding.UTF8.GetBytes("Hello, World!");
        var hash = hashWrapper.Value.ComputeHash(data);
        Console.WriteLine(BitConverter.ToString(hash));
    }
}