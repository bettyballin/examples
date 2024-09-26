csharp
using System;
using System.Security.Cryptography;

public static class SecureGuidGenerator
{
    [ThreadStatic]
    static RandomNumberGenerator rng;

    public static Guid GetNext()
    {
        if (rng == null) rng = RandomNumberGenerator.Create();
        var bytes = new byte[16];
        rng.GetBytes(bytes);
        return new Guid(bytes);
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(SecureGuidGenerator.GetNext());
    }
}