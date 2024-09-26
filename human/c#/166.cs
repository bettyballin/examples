csharp
using System;
using System.Security;
using System.Security.Policy;

class Program
{
    static void Main()
    {
        EvidenceBase[] hostEvidence = { new Zone(SecurityZone.MyComputer) };
        Evidence e = new Evidence(hostEvidence, null);

        AppDomain d = AppDomain.CreateDomain("New Domain", e);

        d.ExecuteAssemblyByName("ShowWinIni");
    }
}