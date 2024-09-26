csharp
using System;
using Newtonsoft.Json;

public class Program
{
    public static void Main()
    {
        var obj = new MyClass { MyProperty = "Hello, World!" };
        var json = JsonConvert.SerializeObject(obj);
        Console.WriteLine(json);
    }
}

[JsonProperty(TypeNameHandling = TypeNameHandling.Auto)]
public class MyClass
{
    public string MyProperty { get; set; }
}