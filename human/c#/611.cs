Not possible. The code you provided is PowerShell, not C#. Here is the equivalent C# code:

csharp
using System.Management.Automation;
using System.Management.Automation.Runspaces;

class Program
{
    static void Main(string[] args)
    {
        string exchangeServer = "http://MY-EXCH-SERVER/PowerShell/";
        string configName = "Microsoft.Exchange";

        WSManConnectionInfo connectionInfo = new WSManConnectionInfo(new Uri(exchangeServer), configName);
        Runspace runspace = RunspaceFactory.CreateRunspace(connectionInfo);
        runspace.Open();
    }
}