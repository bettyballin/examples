csharp
using System;
using System.Web.Security;

class Program
{
    static void Main()
    {
        var isPersistent = true; // or false
        var NoPersistenceExpiryDate = DateTime.MinValue;

        var expires = isPersistent 
                    ? DateTime.Now.Add(FormsAuthentication.Timeout) 
                    : NoPersistenceExpiryDate;

        Console.WriteLine(expires);
    }
}