csharp
using System;
using System.Net.Security;
using System.ServiceModel;

[MessageContract]
public class MyMessage
{
    [MessageHeader(ProtectionLevel = ProtectionLevel.Sign)]
    public string MyHeader { get; set; }

    [MessageBodyMember]
    public string MyBody { get; set; }
}

class Program
{
    static void Main()
    {
        MyMessage message = new MyMessage();
        message.MyHeader = "Hello";
        message.MyBody = "World";
        Console.WriteLine(message.MyHeader);
        Console.WriteLine(message.MyBody);
    }
}