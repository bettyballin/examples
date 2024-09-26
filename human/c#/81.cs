csharp
using System;
using System.Web.Services;
using System.Web.Services.Protocols;

[WebService(Namespace = "http://example.com/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
public class SomeServer : WebService
{
    [WebMethod]
    [SoapDocumentMethodAttribute(
        "http://example.com/SomeServer/SomeServerFunction",
        Use = SoapBindingUse.Literal,
        ParameterStyle = SoapParameterStyle.Bare)]
    public string SomeServerFunction(string parameter)
    {
        // Implement the function logic here
        return "Function executed successfully";
    }
}

class Program
{
    static void Main()
    {
        SomeServer server = new SomeServer();
        Console.WriteLine(server.SomeServerFunction("test"));
    }
}