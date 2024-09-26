csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        string address = "http://localhost:8080/MyService";
        BasicHttpBinding myBinding = new BasicHttpBinding();

        var factory = new ChannelFactory<IMyService>(myBinding, new EndpointAddress(address));
        //for HttpClientCredentialType.Basic
        factory.Credentials.UserName.UserName = "administrator";
        factory.Credentials.UserName.Password = "abcd1234!";
        //for window credentials
        //factory.Credentials.Windows.ClientCredential.UserName = "administrator";
        //factory.Credentials.Windows.ClientCredential.Password = "abcd1234!";
        var channel = factory.CreateChannel();

        // Use the channel
        var result = channel.MyMethod();
        Console.WriteLine(result);
    }
}

[ServiceContract]
public interface IMyService
{
    [OperationContract]
    string MyMethod();
}