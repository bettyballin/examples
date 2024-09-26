csharp
using System;
using System.Security;
using System.Security.Principal;

class Program
{
    static void Main(string[] args)
    {
        AppDomain.CurrentDomain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal);
    }
}