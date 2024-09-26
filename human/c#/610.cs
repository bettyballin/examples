This code is not C# code, it's PowerShell code. However, I can provide you with the equivalent C# code:

csharp
using System;
using System.Management.Automation;
using System.Management.Automation.Runspaces;

class Program
{
    static void Main(string[] args)
    {
        var computerName = "MY-EXCH-SERVER";
        var credential = (PSCredential)null;

        var connectionInfo = new WSManConnectionInfo(new Uri("http://" + computerName + "/powershell"), "http://schemas.microsoft.com/powershell/Microsoft.PowerShell", credential);
        var runspace = RunspaceFactory.CreateRunspace(connectionInfo);
        runspace.Open();
    }
}