csharp
using System;
using System.Security.Cryptography;
using System.Xml;
using Microsoft.WindowsAzure.Storage;
using Microsoft.WindowsAzure.Storage.Table;

class Program
{
    static TableRequestOptions _tableRequestOptions;

    static void Main(string[] args)
    {
        IKey tableStorageKey = GetTableStorageKey();
        _tableRequestOptions = new TableRequestOptions
        {
            EncryptionPolicy = new TableEncryptionPolicy(tableStorageKey, null)
        };

        // Use _tableRequestOptions for Azure Table operations...
    }

    static IKey GetTableStorageKey()
    {
        using (var rsaCsp = new RSACryptoServiceProvider(2048))
        {
            try
            {
                XmlDocument doc = new XmlDocument();
                doc.Load(AppDomain.CurrentDomain.SetupInformation.ConfigurationFile);
                XmlElement node = doc.SelectSingleNode("/configuration/MyTableStorageRsaKey") as XmlElement;

                rsaCsp.FromXmlString(node.OuterXml);

                return new RsaKey("MyTableStorageRsaKey", rsaCsp);
            }
            finally
            {
                rsaCsp.PersistKeyInCsp = false;
            }
        }
    }
}

public class RsaKey : IKey
{
    public string Id { get; private set; }
    public byte[] KeyMaterial { get; private set; }

    public RsaKey(string id, RSACryptoServiceProvider rsaCsp)
    {
        Id = id;
        KeyMaterial = rsaCsp.ExportParameters(true).GetBytes();
    }
}

public interface IKey
{
    string Id { get; }
    byte[] KeyMaterial { get; }
}