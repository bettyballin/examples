csharp
using System;
using Microsoft.Web.Services3;
using Microsoft.Web.Services3.Security.Tokens;
using Microsoft.Web.Services3.Security.Policy;

public class FooBarHttpServiceWse : WebServicesClientProtocol
{
    public void SetClientCredential(UsernameToken token)
    {
        this.RequestSoapContext.Security.Tokens.Add(token);
    }

    public void SetPolicy(Policy policy)
    {
        this.Policy = policy;
    }

    public void CallSomeServerFunction(YourRequest request)
    {
        // Implement server function call here
    }
}

public class FooBarPolicy : Policy
{
    public FooBarPolicy()
    {
        // Implement policy here
    }
}

public class YourRequest
{
    // Implement your request class here
}

class Program
{
    static void Main(string[] args)
    {
        FooBarHttpServiceWse wse = new FooBarHttpServiceWse();
        wse.SetClientCredential(new UsernameToken(
            "username",
            "password",
            PasswordOption.SendPlainText));
        wse.SetPolicy(new FooBarPolicy());
        YourRequest yourRequest = new YourRequest();
        wse.CallSomeServerFunction(yourRequest);
    }
}