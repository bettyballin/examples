csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        var basicHttpBinding = new BasicHttpBinding(BasicHttpSecurityMode.TransportWithMessageCredential);
        basicHttpBinding.Security.Message.ClientCredentialType = BasicHttpMessageCredentialType.UserName;

        Console.WriteLine("BasicHttpBinding created with TransportWithMessageCredential security mode and UserName client credential type.");
    }
}