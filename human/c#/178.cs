csharp
using System;
using System.Configuration;

class Program
{
    static void Main()
    {
        ProtectSection("appSettings", "DataProtectionConfigurationProvider");
    }

    static void ProtectSection(string sectionName, string providerName)
    {
        Configuration config = ConfigurationManager.OpenExeConfiguration(ConfigurationUserLevel.None);
        ConfigurationSection section = config.GetSection(sectionName);
        section.SectionInformation.ProtectSection(providerName);
        section.SectionInformation.ForceSave = true;
        config.Save(ConfigurationSaveMode.Modified);
    }
}