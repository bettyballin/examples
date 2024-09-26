csharp
using System;
using System.Security.Cryptography;
using System.Text;
using Microsoft.Extensions.ObjectPool;

public class HashWrapper : IDisposable
{
    public HashAlgorithm Value { get; }

    public HashWrapper()
    {
        Value = SHA256.Create();
    }

    public void Dispose()
    {
        Value.Dispose();
    }
}

public class ObjectIdentifier
{
    private static ObjectPool<HashWrapper> hashObjects = ObjectPool.Create<HashWrapper>();

    public ObjectIdentifier(string name)
    {
        if (name == null)
        {
            throw new ArgumentNullException(nameof(name));
        }

        var hashworker = hashObjects.Get();
        try
        {
            Id = Convert.ToBase64String(hashworker.Value.ComputeHash(Encoding.UTF8.GetBytes(name)));
        }
        finally
        {
            hashObjects.Return(hashworker);
        }            
    }

    public string Id { get; init; }

    public override string ToString()
    {
        return Id;
    }
}

class Program
{
    static void Main(string[] args)
    {
        var obj = new ObjectIdentifier("Hello World");
        Console.WriteLine(obj.ToString());
    }
}