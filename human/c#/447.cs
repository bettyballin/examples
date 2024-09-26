csharp
using System;
using System.Management;

public class Program
{
    public static string GetAntivirus()
    {
        try
        {
            string data = "";
            string scope = "root\\SecurityCenter";
            if (Environment.OSVersion.Version.Major > 5) scope += "2";
            foreach (ManagementObject antivirus in new ManagementObjectSearcher(scope, "SELECT * FROM AntiVirusProduct").Get())
            {
                data += antivirus["displayName"].ToString();
            }
            return data != "" ? data : "No Antivirus";
        }
        catch
        {
            return "No Antivirus";
        }
    }

    public static string GetFirewall()
    {
        try
        {
            string data = "";
            string scope = "root\\SecurityCenter";
            if (Environment.OSVersion.Version.Major > 5) scope += "2";
            foreach (ManagementObject firewall in new ManagementObjectSearcher(scope, "SELECT * FROM FirewallProduct").Get())
            {
                data += firewall["displayName"].ToString();
            }
            return data != "" ? data : "No Firewall";
        }
        catch
        {
            return "No Firewall";
        }
    }

    public static void Main()
    {
        Console.WriteLine("Antivirus: " + GetAntivirus());
        Console.WriteLine("Firewall: " + GetFirewall());
    }
}