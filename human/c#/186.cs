csharp
using System;
using System.Xml;

class Program
{
    static void Main()
    {
        string xml = @"
<client>
  <endpoint>
    <headers>
      <wsse:UsernameToken xmlns:wsse='http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd'>
        <wsse:Username>Bob</wsse:Username>
        <wsse:Password Type='http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText'>
           1234
        </wsse:Password>
      </wsse:UsernameToken>
    </headers>
  </endpoint>
</client>";

        XmlDocument xmlDoc = new XmlDocument();
        xmlDoc.LoadXml(xml);
        Console.WriteLine(xmlDoc.OuterXml);
    }
}