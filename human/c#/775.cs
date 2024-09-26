csharp
using System;
using System.Security.Cryptography.Xml;

class Program
{
    static void Main()
    {
        SignedXml signedXml = new SignedXml();
        signedXml.SignedInfo.SignatureMethod = SignedXml.XmlDsigRSASHA1Url;
    }
}