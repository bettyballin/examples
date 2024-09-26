csharp
using Newtonsoft.Json;
using System;

public class SomeUniversallyUsedClass
{
    static SomeUniversallyUsedClass()
    {
        JsonConvert.DefaultSettings = () => new JsonSerializerSettings { MaxDepth = 128 };
    }

    public static void Main(string[] args)
    {
        // Now the class can be used
        var instance = new SomeUniversallyUsedClass();
    }

    // Remainder of the class
}