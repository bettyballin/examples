csharp
using System;
using System.Security.Cryptography;

public class RSAES_PKCS1v15_Decryptor : RSAPKCS1KeyExchangeDeformatter
{
    public RSAES_PKCS1v15_Decryptor(RSA rsa) : base(rsa) { }
}

public class RSAES_PKCS1v15_Encryptor : RSAPKCS1KeyExchangeFormatter
{
    public RSAES_PKCS1v15_Encryptor(RSA rsa) : base(rsa) { }
}

public class RSAES_OAEP_SHA_Decryptor : RSAOAEPKeyExchangeDeformatter
{
    public RSAES_OAEP_SHA_Decryptor(RSA rsa) : base(rsa, HashAlgorithmName.SHA1, 0) { }
}

public class RSAES_OAEP_SHA_Encryptor : RSAOAEPKeyExchangeFormatter
{
    public RSAES_OAEP_SHA_Encryptor(RSA rsa) : base(rsa, HashAlgorithmName.SHA1, 0) { }
}