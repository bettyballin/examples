csharp
using System;
using System.Linq;
using System.Reflection;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var types = AppDomain.CurrentDomain.GetAssemblies()
            .SelectMany(
                a => a.GetTypes()
                    .Where(t => typeof(SymmetricAlgorithm).IsAssignableFrom(t))
            );

        foreach (var type in types)
        {
            Console.WriteLine(type.Name);
        }
    }
}