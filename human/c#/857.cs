Here is the modified code:

csharp
using System;
using System.Collections.ObjectModel;
using System.Management.Automation;
using System.Management.Automation.Runspaces;
using XenAPI;

namespace XenSnapshotsXenAccess
{
    public class XenSessionAccess
    {
        private Session xenSession = null;

        public Session XenSession { get { return xenSession; } set { xenSession = value; } }

        public void Logout()
        {
            if (XenSession != null)
            {
                XenSession.logout(XenSession);
            }
        }

        public XenSessionAccess(string poolMasterServerUrl, string xml_creds_path)
        {
            Collection<PSObject> results = null;
            PSCredential psCredential = null;

            InitialSessionState initialSessionState = InitialSessionState.CreateDefault2();

            using (Runspace runSpace = RunspaceFactory.CreateRunspace(initialSessionState))
            {
                runSpace.Open();

                using (PowerShell powerShell = PowerShell.Create())
                {
                    powerShell.Runspace = runSpace;
                    powerShell.AddCommand("Import-CliXml");

                    powerShell.AddArgument(xml_creds_path);
                    results = powerShell.Invoke();

                    if (results.Count == 1)
                    {
                        PSObject psOutput = results[0];
                        psCredential = (PSCredential)psOutput.BaseObject;
                    }
                    else
                    {
                        throw new Exception("Could not obtain pool master server credentials");
                    }
                }

                runSpace.Close();
            }

            initialSessionState = InitialSessionState.CreateDefault2();
            initialSessionState.ImportPSModule(new string[] { "XenServerPSModule" });
            initialSessionState.ExecutionPolicy = Microsoft.PowerShell.ExecutionPolicy.Unrestricted;

            SessionStateVariableEntry psCredential_var = new SessionStateVariableEntry("psCredential", psCredential, "Credentials to log into pool master server");
            initialSessionState.Variables.Add(psCredential_var);

            SessionStateVariableEntry poolUrl_var = new SessionStateVariableEntry("poolUrl", poolMasterServerUrl, "Url of pool master server");
            initialSessionState.Variables.Add(poolUrl_var);

            using (Runspace runSpace = RunspaceFactory.CreateRunspace(initialSessionState))
            {
                runSpace.Open();

                using (PowerShell powerShell = PowerShell.Create())
                {
                    powerShell.Runspace = runSpace;
                    powerShell.AddScript(@"$psCredential | Connect-XenServer -url $poolUrl -SetDefaultSession -PassThru");
                    results = powerShell.Invoke();
                }

                if (results.Count == 1)
                {
                    PSObject psOutput = results[0];
                    XenSession = (Session)psOutput.BaseObject;
                }
                else
                {
                    throw new Exception(String.Format("Could not create session for {0}", poolMasterServerUrl));
                }

                runSpace.Close();
            }
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            string poolMasterServerUrl = "https://your-xenserver-pool-master-server.com";
            string xml_creds_path = @"C:\path\to\your\credentials.xml";

            XenSessionAccess xenSessionAccess = new XenSessionAccess(poolMasterServerUrl, xml_creds_path);

            // Use the xenSessionAccess object as needed
            Console.WriteLine("XenSession created successfully!");

            xenSessionAccess.Logout();

            Console.WriteLine("Logged out successfully!");
        }
    }
}