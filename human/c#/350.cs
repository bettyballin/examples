csharp
using System;
using System.Text;
using System.ServiceModel;
using System.ServiceModel.Channels;

class Program
{
    static void Main()
    {
        var securityElement = SecurityBindingElement.CreateUserNameOverTransportBindingElement();
        securityElement.AllowInsecureTransport = true;

        var encodingElement = new TextMessageEncodingBindingElement(MessageVersion.Soap11, Encoding.UTF8);
        var transportElement = new HttpTransportBindingElement();

        var binding = new CustomBinding(securityElement, encodingElement, transportElement);
    }
}