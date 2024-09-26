csharp
using System;
using Microsoft.Web.Services3;
using Microsoft.Web.Services3.Addressing;

class Program
{
    static void Main()
    {
        WebServicesClientProtocol wse = new WebServicesClientProtocol();
        wse.Url = "http://example.com/service.asmx";
        wse.RequestSoapContext.Addressing.Action = new Action("CallSomeServerFunction");
        wse.CallSomeServerFunction();
    }
}