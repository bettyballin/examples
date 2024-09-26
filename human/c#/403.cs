csharp
using System;

public class JsonpMediaTypeFormatter : MediaTypeFormatter
{
    public override bool CanWriteType(Type type)
    {
        // Check type here and return true only for the types you want to allow JSONP
        return true;
    }
}

class Program
{
    static void Main()
    {
        var formatter = new JsonpMediaTypeFormatter();
        Console.WriteLine(formatter.CanWriteType(typeof(string)));
    }
}