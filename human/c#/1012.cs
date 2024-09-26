csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

public class CertificateRequestProperties
{
    public string Subject { get; set; }
    public EnrollKeyUsages KeyUsages { get; set; }
    public string KeyStorageProviderName { get; set; }
    public ExportOption Exportable { get; set; }
    public KeyProtectionLevel KeyProtectionLevel { get; set; }
    public string KeyAlgorithmName { get; set; }
    public string HashAlgorithmName { get; set; }
    public string FriendlyName { get; set; }
    public X509ExtensionCollection Extensions { get; set; }
    public bool UseExistingKey { get; set; }
    public string[] SuppressedDefaults { get; set; }
}

public enum EnrollKeyUsages
{
    Signing
}

public enum ExportOption
{
    NotExportable
}

public enum KeyProtectionLevel
{
    // Add values as needed
}

class Program
{
    public const string SUBJECT_KEY_IDENTIFIER = "2.5.29.14";
    public const string CERTIFICATE_FRIENDLY_NAME = "Certificate Friendly Name";
    public const string microsoftPlatformCryptoProvider = "Microsoft Platform Crypto Provider";
    public const string keyAlgorithmName = "RSA";
    public const string hashAlgorithmName = "SHA256";

    static void Main()
    {
        var subject = "CN=Example Certificate";
        var keyProtectionLevel = KeyProtectionLevel.None;
        var basicConstraint = new X509BasicConstraintsExtension(false, false, 0, true);
        var extendedKeyUsage = new X509EnhancedKeyUsageExtension(new OidCollection { new Oid("1.3.6.1.5.5.7.3.8") }, true);
        var keyUsage = new X509KeyUsageExtension(X509KeyUsageFlags.DigitalSignature, true);

        var certificateRequestProperties = new CertificateRequestProperties
        {
            Subject = subject,
            KeyUsages = EnrollKeyUsages.Signing,
            KeyStorageProviderName = microsoftPlatformCryptoProvider,
            Exportable = ExportOption.NotExportable,
            KeyProtectionLevel = keyProtectionLevel,
            KeyAlgorithmName = keyAlgorithmName,
            HashAlgorithmName = hashAlgorithmName,
            FriendlyName = CERTIFICATE_FRIENDLY_NAME,
            Extensions = new X509ExtensionCollection { basicConstraint, extendedKeyUsage, keyUsage },
            UseExistingKey = false,
            SuppressedDefaults = new string[] { SUBJECT_KEY_IDENTIFIER }
        };
    }
}