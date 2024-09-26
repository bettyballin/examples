csharp
using System;
using System.Xml;
using System.Security.Cryptography.Xml;

public class SignedXmlWithId : SignedXml
{
    public SignedXmlWithId(XmlDocument xml) : base(xml)
    {
    }

    public SignedXmlWithId(XmlElement xmlElement) 
        : base(xmlElement)
    {       
    }

    public override XmlElement GetIdElement(XmlDocument doc, string id)
    {
        // check to see if it's a standard ID reference
        XmlElement idElem = base.GetIdElement(doc, id);

        if (idElem == null)
        {
            XmlNamespaceManager nsManager = new XmlNamespaceManager(doc.NameTable);
            nsManager.AddNamespace("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

            idElem = doc.SelectSingleNode("//*[@wsu:Id=\"" + id + "\"]", nsManager) as XmlElement;
        }

        return idElem;
    }
}

class Program
{
    static void Main()
    {
        string xml = "<root><element wsu:Id=\"myId\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">Hello World!</element></root>";
        XmlDocument xmlDoc = new XmlDocument();
        xmlDoc.LoadXml(xml);

        SignedXmlWithId signedXml = new SignedXmlWithId(xmlDoc);
        XmlElement idElement = signedXml.GetIdElement(xmlDoc, "myId");

        if (idElement != null)
        {
            Console.WriteLine(idElement.InnerText);
        }
        else
        {
            Console.WriteLine("Element not found");
        }
    }
}