csharp
using System;
using System.Xml.Linq;

public class CredentialValidator
{
    private XDocument doc;

    public CredentialValidator(string xml)
    {
        doc = XDocument.Parse(xml);
    }

    public override void Validate(string suppliedUserName, string suppliedPassword)
    {
        string validUserName = doc.Root.Element("Credentials").Attribute("username").Value;
        string validPassword = doc.Root.Element("Credentials").Attribute("password").Value;

        if (suppliedUserName != validUserName || suppliedPassword != validPassword)
        {
            throw new Exception("Invalid username or password");
        }
    }
}

class Program
{
    static void Main()
    {
        string xml = "<root><Credentials username='admin' password='password'/></root>";
        CredentialValidator validator = new CredentialValidator(xml);
        try
        {
            validator.Validate("admin", "password");
            Console.WriteLine("Valid credentials");
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}