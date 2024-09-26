csharp
using System;
using System.Xml;

class Program
{
    static void Main()
    {
        string xml = @"
<connectionStrings>
  <add name=""Name"" 
   providerName=""System.Data.ProviderName"" 
   connectionString=""Valid Connection String;"" />
</connectionStrings>
";

        XmlDocument xmlDoc = new XmlDocument();
        xmlDoc.LoadXml(xml);
        Console.WriteLine(xmlDoc.OuterXml);
    }
}