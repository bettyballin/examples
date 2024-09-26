csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var bytes = new byte[128];
        using (var rng = RandomNumberGenerator.Create())
            rng.GetBytes(bytes);

        Console.WriteLine(BitConverter.ToString(bytes));
    }
}