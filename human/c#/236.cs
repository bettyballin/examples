using System;
using System.Configuration;

class Program
{
    static void Main()
    {
        var config = new Configuration();
        var security = new SecurityElement("security");
        security.AddAttribute("mode", "TransportWithMessageCredential");
        var message = new SecurityElement("message");
        message.AddAttribute("clientCredentialType", "UserName");
        security.AddChild(message);
        config.Sections.Add("security", security);
        Console.WriteLine(config.ToString());
    }
}

public class SecurityElement
{
    private string name;
    private ConfigurationElementCollection children;
    private ConfigurationElementPropertyCollection properties;

    public SecurityElement(string name)
    {
        this.name = name;
        children = new ConfigurationElementCollection();
        properties = new ConfigurationElementPropertyCollection();
    }

    public void AddAttribute(string name, string value)
    {
        properties.Add(new ConfigurationElementProperty(name, value));
    }

    public void AddChild(ConfigurationElement child)
    {
        children.Add(child);
    }

    public override string ToString()
    {
        var xml = "<" + name;
        foreach (ConfigurationElementProperty property in properties)
        {
            xml += " " + property.Name + "=\"" + property.Value + "\"";
        }
        xml += ">";
        foreach (ConfigurationElement child in children)
        {
            xml += child.ToString();
        }
        xml += "</" + name + ">";
        return xml;
    }
}

public class Configuration
{
    private ConfigurationSectionCollection sections;

    public Configuration()
    {
        sections = new ConfigurationSectionCollection();
    }

    public void AddSection(string name, ConfigurationElement section)
    {
        sections.Add(name, section);
    }

    public override string ToString()
    {
        var xml = "";
        foreach (ConfigurationSection section in sections)
        {
            xml += section.ToString();
        }
        return xml;
    }
}

public class ConfigurationSection
{
    private string name;
    private ConfigurationElement element;

    public ConfigurationSection(string name, ConfigurationElement element)
    {
        this.name = name;
        this.element = element;
    }

    public override string ToString()
    {
        return element.ToString();
    }
}

public class ConfigurationElementCollection : System.Collections.Generic.List<ConfigurationElement> { }

public class ConfigurationElementPropertyCollection : System.Collections.Generic.List<ConfigurationElementProperty> { }

public class ConfigurationElementProperty
{
    private string name;
    private string value;

    public ConfigurationElementProperty(string name, string value)
    {
        this.name = name;
        this.value = value;
    }

    public string Name
    {
        get { return name; }
    }

    public string Value
    {
        get { return value; }
    }
}

public class ConfigurationSectionCollection : System.Collections.Generic.Dictionary<string, ConfigurationSection> { }