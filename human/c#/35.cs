csharp
using System;
using System.Security;
using System.ServiceModel.Security;

class Program
{
    static void Main()
    {
        ServiceSecurityContext current = ServiceSecurityContext.Current;

        if (current != null && !current.IsAnonymous && current.WindowsIdentity != null)
        {
            string userName = current.WindowsIdentity.Name;
            Console.WriteLine(userName);
        }
        else
        {
            Console.WriteLine("Current context is null or anonymous.");
        }
    }
}