csharp
using System;
using System.Reflection;
using Newtonsoft.Json.Serialization;

public class MySerializationBinder : DefaultSerializationBinder
{
    const string MyNamespace = "foo"; 

    public override Type BindToType(string assemblyName, string typeName)
    {
        if (!typeName.StartsWith(MyNamespace, StringComparison.OrdinalIgnoreCase))
            throw new JsonSerializationException($"Request type {typeName} not supported, please use an IFoo");
        var type = base.BindToType(assemblyName, typeName);
        return type;
    }
}

class Program
{
    static void Main()
    {
        MySerializationBinder binder = new MySerializationBinder();
        Console.WriteLine(binder.BindToType("AssemblyName", "foo.MyType"));
    }
}