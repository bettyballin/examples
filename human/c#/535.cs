csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        bool bUseSSL = true;
        bool bSSLMsgCredentialBypass = true;

        BasicHttpBinding b = default(BasicHttpBinding);
        if (bUseSSL)
        {
            //check for ssl msg credential bypass
            if (bSSLMsgCredentialBypass)
            {
                b = new BasicHttpBinding(BasicHttpSecurityMode.TransportWithMessageCredential);
            }
            else
            {
                b = new BasicHttpBinding(BasicHttpSecurityMode.Transport);
            }

            b.TransferMode = TransferMode.Buffered;
            b.MaxReceivedMessageSize = int.MaxValue;
            b.MessageEncoding = WSMessageEncoding.Text;
            b.TextEncoding = System.Text.Encoding.UTF8;
            b.BypassProxyOnLocal = false;
            //b.Security.Message.ClientCredentialType = BasicHttpMessageCredentialType.Certificate;
        }

        Console.WriteLine("BasicHttpBinding settings:");
        Console.WriteLine($"TransferMode: {b.TransferMode}");
        Console.WriteLine($"MaxReceivedMessageSize: {b.MaxReceivedMessageSize}");
        Console.WriteLine($"MessageEncoding: {b.MessageEncoding}");
        Console.WriteLine($"TextEncoding: {b.TextEncoding}");
        Console.WriteLine($"BypassProxyOnLocal: {b.BypassProxyOnLocal}");
    }
}