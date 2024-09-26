csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Channels;

public class Program
{
    public static void Main()
    {
        // Create a proxy instance
        var proxy = new MyServiceProxy();

        // Create an untyped header
        var untyped = MessageHeader.CreateHeader("MyHeader", "http://my.namespace", "HeaderValue");

        using (var contextScope = new OperationContextScope(proxy.InnerChannel))
        {
            OperationContext.Current.OutgoingMessageHeaders.Add(untyped);
            proxy.DoOperation("parameter");
        }
    }
}

// Assuming MyServiceProxy is a generated proxy class
public class MyServiceProxy : ClientBase<IMyService>
{
    public MyServiceProxy() : base("MyEndpoint") { }

    public void DoOperation(string parameter)
    {
        Channel.DoOperation(parameter);
    }
}

// Assuming IMyService is a service contract
[ServiceContract]
public interface IMyService
{
    [OperationContract]
    void DoOperation(string parameter);
}