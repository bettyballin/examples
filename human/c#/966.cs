csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Xml;

class Program
{
    static void Main()
    {
        string signedInfo = "<SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"></CanonicalizationMethod><SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\"></SignatureMethod><Reference URI=\"\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"></Transform></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"></DigestMethod><DigestValue>AjI/9vkjyZWM9noiF0J0RRZEUAjBil96ETvT9Cl85rI=</DigestValue></Reference></SignedInfo>";

        XmlDocument xmlDoc = new XmlDocument();
        xmlDoc.LoadXml(signedInfo);

        XmlElement signedInfoElement = xmlDoc.DocumentElement;

        byte[] digestValue = Convert.FromBase64String(signedInfoElement.SelectSingleNode(".//DigestValue").InnerText);

        RSA rsa = RSA.Create();
        rsa.ImportProtectedData(null, null, null);

        byte[] signature = rsa.SignData(digestValue, HashAlgorithmName.SHA256, RSASignaturePadding.Pkcs1);

        Console.WriteLine(Convert.ToBase64String(signature));
    }
}