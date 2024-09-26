csharp
using System;
using System.Reflection;
using System.Security;
using System.Security.Policy;

class Program
{
    static void Main(string[] args)
    {
        string path = @"C:\Path\To\Your\Assembly.dll";
        Assembly externalAssembly = Assembly.LoadFrom(path);

        // Retrieve the permission set of the external assembly
        PermissionSet permSet = SecurityManager.ResolvePolicy(externalAssembly.Evidence);
        if (!permSet.IsUnrestricted())
        {
            throw new Exception("Assembly is not fully trusted!");
        }
    }
}