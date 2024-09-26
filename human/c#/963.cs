csharp
using System;
using Newtonsoft.Json;

public class Root<TBase>
{
    [JsonProperty(TypeNameHandling = TypeNameHandling.Auto)]
    public TBase Data { get; set; }
}

class Program
{
    static void Main()
    {
        Root<string> root = new Root<string>();
        root.Data = "Hello, World!";
        Console.WriteLine(JsonConvert.SerializeObject(root));
    }
}