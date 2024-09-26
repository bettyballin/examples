csharp
using System;
using Microsoft.Web.Services3.Design;

namespace FooBarPolicyNamespace
{
    class Program
    {
        static void Main(string[] args)
        {
            FooBarPolicy policy = new FooBarPolicy();
            Console.WriteLine(policy.Assertions.Count);
        }
    }

    public class FooBarPolicy : Policy
    {
        public FooBarPolicy()
        {
            this.Assertions.Add(new UsernameOverTransportAssertion());
        }
    }
}