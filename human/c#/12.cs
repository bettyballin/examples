csharp
using System;
using System.Web;
using System.Web.Mvc;
using System.Configuration;
using System.Net;

[AttributeUsage(AttributeTargets.Class, AllowMultiple = false)]
public class FilterIPAttribute : AuthorizeAttribute
{
    public string ConfigurationKeyAllowedSingleIPs { get; set; }
    public string ConfigurationKeyAllowedMaskedIPs { get; set; }
    public string ConfigurationKeyDeniedSingleIPs { get; set; }
    public string ConfigurationKeyDeniedMaskedIPs { get; set; }

    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        var allowedSingleIPs = ConfigurationManager.AppSettings[ConfigurationKeyAllowedSingleIPs].Split(',');
        var allowedMaskedIPs = ConfigurationManager.AppSettings[ConfigurationKeyAllowedMaskedIPs].Split(',');
        var deniedSingleIPs = ConfigurationManager.AppSettings[ConfigurationKeyDeniedSingleIPs].Split(',');
        var deniedMaskedIPs = ConfigurationManager.AppSettings[ConfigurationKeyDeniedMaskedIPs].Split(',');

        var userIP = httpContext.Request.UserHostAddress;

        if (IsIPAllowed(allowedSingleIPs, allowedMaskedIPs, userIP) && !IsIPDenied(deniedSingleIPs, deniedMaskedIPs, userIP))
        {
            return true;
        }

        return false;
    }

    private bool IsIPAllowed(string[] allowedSingleIPs, string[] allowedMaskedIPs, string userIP)
    {
        foreach (var ip in allowedSingleIPs)
        {
            if (ip.Trim() == userIP)
            {
                return true;
            }
        }

        foreach (var ip in allowedMaskedIPs)
        {
            var parts = ip.Split(';');
            var ipRange = IPNetwork.Parse(parts[0].Trim(), parts[1].Trim());
            if (ipRange.Contains(IPAddress.Parse(userIP)))
            {
                return true;
            }
        }

        return false;
    }

    private bool IsIPDenied(string[] deniedSingleIPs, string[] deniedMaskedIPs, string userIP)
    {
        foreach (var ip in deniedSingleIPs)
        {
            if (ip.Trim() == userIP)
            {
                return true;
            }
        }

        foreach (var ip in deniedMaskedIPs)
        {
            var parts = ip.Split(';');
            var ipRange = IPNetwork.Parse(parts[0].Trim(), parts[1].Trim());
            if (ipRange.Contains(IPAddress.Parse(userIP)))
            {
                return true;
            }
        }

        return false;
    }
}

[FilterIP(
    ConfigurationKeyAllowedSingleIPs = "AllowedAdminSingleIPs",
    ConfigurationKeyAllowedMaskedIPs = "AllowedAdminMaskedIPs",
    ConfigurationKeyDeniedSingleIPs = "DeniedAdminSingleIPs",
    ConfigurationKeyDeniedMaskedIPs = "DeniedAdminMaskedIPs"
)]
public class HomeController : Controller
{
    public ActionResult Index()
    {
        return View();
    }
}


xml
<configuration>
  <appSettings>
    <add key="AllowedAdminSingleIPs" value="localhost,127.0.0.1"/>
    <add key="AllowedAdminMaskedIPs" value="10.2.0.0;255.255.0.0"/>
    <add key="DeniedAdminSingleIPs" value=""/>
    <add key="DeniedAdminMaskedIPs" value=""/>
  </appSettings>
</configuration>