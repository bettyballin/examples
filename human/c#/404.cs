csharp
using System.Net.Http;
using System.Net.Http.Formatting;

public class MyType
{
    public string Foo { get; set; }
}

public class JsonpFormatter : MediaTypeFormatter
{
    public override bool CanReadType(Type type)
    {
        return false;
    }

    public override bool CanWriteType(Type type)
    {
        return true;
    }

    public override Task WriteToStreamAsync(Type type, object value, Stream writeStream, HttpContent content, TransportContext transportContext)
    {
        var json = JsonConvert.SerializeObject(value);
        var jsonp = string.Format("callback({0})", json);
        var buffer = Encoding.UTF8.GetBytes(jsonp);
        return writeStream.WriteAsync(buffer, 0, buffer.Length);
    }
}

public class Program
{
    public static void Main()
    {
        var anInstanceOfMyType = new MyType { Foo = "bar" };
        var response = new HttpResponseMessage()
        {
            Content = new ObjectContent<MyType>(anInstanceOfMyType, new JsonpFormatter())
        };
        var result = response.Content.ReadAsStringAsync().Result;
        Console.WriteLine(result);
    }
}