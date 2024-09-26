csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Channels;

public class MyService
{
    public void MyServiceMethod()
    {
        var opContext = OperationContext.Current;
        var requestContext = opContext.RequestContext;
        var headers = requestContext.RequestMessage.Headers;
        int headerIndex = headers.FindHeader("ClientIdentification", "");
        if (headerIndex != -1)
        {
            var clientString = headers.GetHeader<string>(headerIndex);
            if (clientString == "ASP_Client")
            {
                // ...
            }
            else
            {
                // ...
            }
        }
        else
        {
            // Handle the case where the header is not found
        }
    }
}