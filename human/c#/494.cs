csharp
using System;
using System.Configuration;

namespace IPFilter
{
    public class IPFilterConfiguration : ConfigurationSection
    {
        [ConfigurationProperty("HttpModule")]
        public HttpModuleElement HttpModule
        {
            get { return (HttpModuleElement)this["HttpModule"]; }
            set { this["HttpModule"] = value; }
        }

        [ConfigurationProperty("Filters")]
        public FilterCollection Filters
        {
            get { return (FilterCollection)this["Filters"]; }
            set { this["Filters"] = value; }
        }
    }

    public class HttpModuleElement : ConfigurationElement
    {
        [ConfigurationProperty("FilterName")]
        public string FilterName
        {
            get { return (string)this["FilterName"]; }
            set { this["FilterName"] = value; }
        }
    }

    public class FilterCollection : ConfigurationElementCollection
    {
        protected override ConfigurationElement CreateNewElement()
        {
            return new FilterElement();
        }

        protected override object GetElementKey(ConfigurationElement element)
        {
            return ((FilterElement)element).Name;
        }
    }

    public class FilterElement : ConfigurationElement
    {
        [ConfigurationProperty("Name")]
        public string Name
        {
            get { return (string)this["Name"]; }
            set { this["Name"] = value; }
        }

        [ConfigurationProperty("DefaultBehavior")]
        public string DefaultBehavior
        {
            get { return (string)this["DefaultBehavior"]; }
            set { this["DefaultBehavior"] = value; }
        }

        [ConfigurationProperty("deny")]
        public DenyElement Deny
        {
            get { return (DenyElement)this["deny"]; }
            set { this["deny"] = value; }
        }

        [ConfigurationProperty("allow")]
        public AllowElement Allow
        {
            get { return (AllowElement)this["allow"]; }
            set { this["allow"] = value; }
        }
    }

    public class DenyElement : ConfigurationElement
    {
        [ConfigurationProperty("hosts")]
        public string Hosts
        {
            get { return (string)this["hosts"]; }
            set { this["hosts"] = value; }
        }
    }

    public class AllowElement : ConfigurationElement
    {
        [ConfigurationProperty("hosts")]
        public string Hosts
        {
            get { return (string)this["hosts"]; }
            set { this["hosts"] = value; }
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var configFileMap = new ExeConfigurationFileMap { ExeConfigFilename = "example.config" };
            var config = ConfigurationManager.OpenMappedExeConfiguration(configFileMap, ConfigurationUserLevel.None);

            var ipFilterConfig = (IPFilterConfiguration)config.GetSection("IPFilter");

            Console.WriteLine(ipFilterConfig.HttpModule.FilterName);

            foreach (FilterElement filter in ipFilterConfig.Filters)
            {
                Console.WriteLine($"Name: {filter.Name}, DefaultBehavior: {filter.DefaultBehavior}");

                if (filter.Deny != null)
                {
                    Console.WriteLine($"Deny: {filter.Deny.Hosts}");
                }

                if (filter.Allow != null)
                {
                    Console.WriteLine($"Allow: {filter.Allow.Hosts}");
                }
            }
        }
    }
}