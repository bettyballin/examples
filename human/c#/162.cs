csharp
using System;
using System.IO;
using System.Security.Cryptography.Xml;
using System.Xml;

class Program
{
    static void Main()
    {
        string xml = "<root><child>text</child></root>";

        XmlDocument doc = new XmlDocument();
        doc.LoadXml(xml);

        System.Security.Cryptography.Xml.Transform t = new System.Security.Cryptography.Xml.XmlDsigC14NTransform();
        // or System.Security.Cryptography.Xml.XmlDsigExcC14NTransform
        t.Resolver = null;
        t.LoadInput(doc);

        Stream stream = (Stream)t.GetOutput(typeof(Stream));
        string canonicalXml = new StreamReader(stream).ReadToEnd();

        Console.WriteLine(canonicalXml);
    }
}

public static class Extensions
{
    public static string ReadToEnd(this StreamReader reader)
    {
        string result = reader.ReadToEnd();
        reader.Close();
        return result;
    }
}