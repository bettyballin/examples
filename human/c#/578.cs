csharp
using Microsoft.Owin;
using System;

class Program
{
    static void Main()
    {
        var context = new OwinContext();
        context.Set("SmartCard", "some_uid");

        string uid = context.Get<string>("SmartCard");

        Console.WriteLine(uid);
    }
}