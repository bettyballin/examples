csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Description;

public class ClientSoapHeaderAdderBehaviour : IEndpointBehavior
{
    public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters)
    {
    }

    public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime)
    {
        clientRuntime.ClientMessageInspectors.Add(new ClientSoapHeaderAdderInspector());
    }

    public void ApplyDispatchBehavior(ServiceEndpoint endpoint, EndpointDispatcher endpointDispatcher)
    {
    }

    public void Validate(ServiceEndpoint endpoint)
    {
    }
}

public class ClientSoapHeaderAdderInspector : IClientMessageInspector
{
    public void AfterReceiveReply(ref Message reply, object correlationState)
    {
    }

    public object BeforeSendRequest(ref Message request, IClientChannel channel)
    {
        // Add SOAP header here
        request.Headers.Add(new MySoapHeader());
        return null;
    }
}

public class MySoapHeader : MessageHeader
{
    public override string Name
    {
        get { return "MySoapHeader"; }
    }

    public override string Namespace
    {
        get { return "http://tempuri.org/"; }
    }

    protected override void OnWriteHeaderContents(XmlDictionaryWriter writer, MessageVersion messageVersion)
    {
        writer.WriteString("My Soap Header Value");
    }
}