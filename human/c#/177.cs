csharp
using System.Web;
using System.Web.Configuration;

public class ConfigurationProtector
{
    private readonly HttpRequest Request;

    public ConfigurationProtector(HttpRequest request)
    {
        Request = request;
    }

    public void ProtectSection(string sectionName, string provider)
    {
        Configuration config = WebConfigurationManager.OpenWebConfiguration(Request.ApplicationPath);
        ConfigurationSection section = config.GetSection(sectionName);

        if (section != null && !section.SectionInformation.IsProtected)
        {
            section.SectionInformation.ProtectSection(provider);
            config.Save();
        }
    }

    public void UnProtectSection(string sectionName)
    {
        Configuration config = WebConfigurationManager.OpenWebConfiguration(Request.ApplicationPath);
        ConfigurationSection section = config.GetSection(sectionName);

        if (section != null && section.SectionInformation.IsProtected)
        {
            section.SectionInformation.UnprotectSection();
            config.Save();
        }
    }
}

class Program
{
    static void Main()
    {
        HttpRequest request = HttpContext.Current.Request;
        ConfigurationProtector protector = new ConfigurationProtector(request);
        protector.ProtectSection("sectionName", "provider");
        protector.UnProtectSection("sectionName");
    }
}