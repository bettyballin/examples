csharp
using System;
using System.Management.Automation;

class Program
{
    static void Main()
    {
        using (var powershell = PowerShell.Create())
        {
            powershell.AddCommand("Set-AdfsRelyingPartyTrust")
                .AddParameter("TargetName", "Relying party name")
                .AddParameter("TokenLifeTime", 5);

            powershell.Invoke();
        }
    }
}