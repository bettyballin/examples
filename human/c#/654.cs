csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.Xml;
using System.Xml;

public class CustomSignedXml : SignedXml
{
    public CustomSignedXml(XmlDocument document) : base(document) { }
}

public class Program
{
    private X509Certificate2 _signingCertificate;
    private XmlDocument _documentToSign;

    public static void Main(string[] args)
    {
        Program program = new Program();
        program._signingCertificate = new X509Certificate2("path_to_your_certificate", "password");
        program._documentToSign = new XmlDocument();
        program._documentToSign.Load("path_to_your_xml_file");

        CustomSignedXml signedXml = program.CreateSignedXml();
        signedXml.ComputeSignature();
        XmlElement signature = signedXml.GetXml();

        program._documentToSign.DocumentElement.AppendChild(program._documentToSign.ImportNode(signature, true));
        program._documentToSign.Save("path_to_your_output_file");
    }

    private CustomSignedXml CreateSignedXml()
    {
        var signedXml = new CustomSignedXml(_documentToSign)
        {
            SigningKey = _signingCertificate.GetRSAPrivateKey(),
            KeyInfo = CreateKeyInfo()
        };

        Reference reference = new Reference("");
        reference.AddTransform(new XmlDsigEnvelopedSignatureTransform());
        reference.DigestMethod = SecurityAlgorithms.Sha256Digest; 

        signedXml.SignedInfo.CanonicalizationMethod = SecurityAlgorithms.ExclusiveC14n;
        signedXml.SignedInfo.SignatureMethod = SecurityAlgorithms.RsaSha256Signature; 
        signedXml.AddReference(reference);

        return signedXml;
    }

    private KeyInfo CreateKeyInfo()
    {
        KeyInfo keyInfo = new KeyInfo();
        keyInfo.AddClause(new KeyInfoX509Data(_signingCertificate));
        return keyInfo;
    }
}