csharp
using System;
using System.IO;
using System.Net;
using System.Xml;

public class Program
{
    public static string SampleFunction(string contactId)
    {
        string getParentCustomer = @"
            <Retrieve xmlns=""http://schemas.microsoft.com/xrm/2011/Contracts/Services"" xmlns:i=""http://www.w3.org/2001/XMLSchema-instance"">
              <entityName>contact</entityName>
              <id>" + contactId + @"</id>
              <columnSet xmlns:a=""http://schemas.microsoft.com/xrm/2011/Contracts"">
                <a:AllColumns>false</a:AllColumns>
                <a:Columns xmlns:b=""http://schemas.microsoft.com/2003/10/Serialization/Arrays"">
                  <b:string>parentcustomeridname</b:string>
                </a:Columns>
              </columnSet>
            </Retrieve>";

        string getParentCustomerResult = SendQuery(getParentCustomer, "Retrieve");

        XmlDocument xmlDoc = new XmlDocument();
        xmlDoc.LoadXml(getParentCustomerResult);
        XmlNodeList keyValuePairs = xmlDoc.GetElementsByTagName("KeyValuePairOfstringanyType");

        foreach (XmlNode results in keyValuePairs)
        {
            if (results.ChildNodes[0].InnerText == "parentcustomeridname")
            {
                return results.ChildNodes[1].ChildNodes[0].InnerText;
            }
            else
            {
                return "No Result";
            }
        }
        return string.Empty;
    }

    public static string SendQuery(string request, string action)
    {
        HttpWebRequest webRequest = (HttpWebRequest)HttpWebRequest.Create("http://your-crm-url.com/XRMServices/2011/Organization.svc/web");
        webRequest.Headers["SOAPAction"] = action;
        webRequest.ContentType = "text/xml; charset=utf-8";
        webRequest.Method = "POST";

        using (StreamWriter writer = new StreamWriter(webRequest.GetRequestStream()))
        {
            writer.Write(request);
        }

        HttpWebResponse webResponse = (HttpWebResponse)webRequest.GetResponse();

        using (StreamReader reader = new StreamReader(webResponse.GetResponseStream()))
        {
            return reader.ReadToEnd();
        }
    }

    public static void Main(string[] args)
    {
        string contactId = "your-contact-id";
        string result = SampleFunction(contactId);
        Console.WriteLine(result);
    }
}