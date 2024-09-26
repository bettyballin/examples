csharp
using System;
using System.Collections.Generic;

public class SignedData
{
    public CMSVersion Version { get; set; }
    public DigestAlgorithmIdentifiers DigestAlgorithms { get; set; }
    public EncapsulatedContentInfo EncapContentInfo { get; set; }
    public CertificateSet Certificates { get; set; }
    public RevocationInfoChoices Crls { get; set; }
    public SignerInfos SignerInfos { get; set; }
}

public class DigestAlgorithmIdentifiers : HashSet<DigestAlgorithmIdentifier> { }

public class SignerInfos : HashSet<SignerInfo> { }

public class CMSVersion { }

public class DigestAlgorithmIdentifier { }

public class EncapsulatedContentInfo { }

public class CertificateSet { }

public class RevocationInfoChoices { }

public class SignerInfo { }

class Program
{
    static void Main(string[] args)
    {
        var signedData = new SignedData
        {
            Version = new CMSVersion(),
            DigestAlgorithms = new DigestAlgorithmIdentifiers(),
            EncapContentInfo = new EncapsulatedContentInfo(),
            Certificates = new CertificateSet(),
            Crls = new RevocationInfoChoices(),
            SignerInfos = new SignerInfos()
        };
    }
}