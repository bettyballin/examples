csharp
using System;
using System.Net;

[AttributeUsage(AttributeTargets.Class, AllowMultiple = false)]
public class FilterIPAttribute : Attribute
{
    public string AllowedSingleIPs { get; set; }
    public string AllowedMaskedIPs { get; set; }

    public bool IsValidIP(string ipAddress)
    {
        var ip = IPAddress.Parse(ipAddress);

        foreach (var singleIP in AllowedSingleIPs.Split(','))
        {
            if (ipAddress == singleIP) return true;
        }

        foreach (var maskedIP in AllowedMaskedIPs.Split(','))
        {
            var parts = maskedIP.Split(';');
            var networkAddress = IPAddress.Parse(parts[0]);
            var subnetMask = IPAddress.Parse(parts[1]);

            if (IsInRange(ip, networkAddress, subnetMask)) return true;
        }

        return false;
    }

    private bool IsInRange(IPAddress address, IPAddress networkAddress, IPAddress subnetMask)
    {
        var addressBytes = address.GetAddressBytes();
        var networkAddressBytes = networkAddress.GetAddressBytes();
        var subnetMaskBytes = subnetMask.GetAddressBytes();

        for (int i = 0; i < addressBytes.Length; i++)
        {
            if ((addressBytes[i] & subnetMaskBytes[i]) != (networkAddressBytes[i] & subnetMaskBytes[i]))
                return false;
        }

        return true;
    }
}

[FilterIP(
    AllowedSingleIPs = "10.2.5.55,192.168.2.2",
    AllowedMaskedIPs = "10.2.0.0;255.255.0.0,192.168.2.0;255.255.255.0"
)]
public class HomeController
{
    public void MyAction(string ipAddress)
    {
        var attribute = (FilterIPAttribute)typeof(HomeController).GetCustomAttributes(typeof(FilterIPAttribute), false).GetValue(0);
        if (attribute.IsValidIP(ipAddress))
        {
            Console.WriteLine("IP address is valid");
        }
        else
        {
            Console.WriteLine("IP address is not valid");
        }
    }
}

public class Program
{
    public static void Main()
    {
        var homeController = new HomeController();
        homeController.MyAction("10.2.5.55");
    }
}