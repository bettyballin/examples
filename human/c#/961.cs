csharp
using System;
using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

public class MySerializationBinder : SerializationBinder
{
    public override Type BindToType(string assemblyName, string typeName)
    {
        return Type.GetType(string.Format("{0}, {1}", typeName, assemblyName));
    }

    public override void BindToName(Type serializedType, out string assemblyName, out string typeName)
    {
        assemblyName = serializedType.Assembly.FullName;
        typeName = serializedType.FullName;
    }
}

class Program
{
    static void Main()
    {
        var settings = new JsonSerializerSettings
        {
            SerializationBinder = new MySerializationBinder(),
            TypeNameHandling = TypeNameHandling.All,
        };

        // Example usage
        var obj = new { foo = "bar" };
        var json = JsonConvert.SerializeObject(obj, Formatting.Indented, settings);
        Console.WriteLine(json);
    }
}