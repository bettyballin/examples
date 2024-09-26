csharp
using Microsoft.Owin;
using System;

class Program
{
    static void Main()
    {
        var context = new OwinContext();
        var client = new ApplicationClient();

        context.Set<ApplicationClient>("oauth:client", client);
    }
}

public class ApplicationClient
{
}