csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
                            "MIICXQIBAAKBgQDr5KvAc6JX22BdpsfQbWam8rjkwJzTC954XQzhLOPeGiAGfkPm\n" +
                            "CLYhBrmxZN6NxiseivpN9yzrRjYeccr+s3A/8q1EbdhmmM4+AxdNzATEsUxL//MS\n" +
                            "VXCaoJhGOfXswokFT8HQod9M6VMmuyDaw9iEorLavV6J/nCmq2HIutcbbwIDAQAB\n" +
                            "AoGBAMt2dgnN8zXSW2ELrIcDBapz6rQrylhigWXR5H0IKhb087CGEeyEkQsVcO8o\n" +
                            "MKmaRrDWcKT00IKyEZXa0pszjFmD6f90H6TrV6BwZKEynAUVqaX4CCn6x9wgppMA\n" +
                            "hWg3eYgoUME3Xgr1Iugb4rqtocEL7Vww/NoUgLXhzHH4RNz5AkEA+mZN2189Te3m\n" +
                            "LmXFIJhV+GxrDmYrgJ0csjoEFHAxKJ52lsXTe1VODWbGWAv59jOrbUKe/aQaj4N1\n" +
                            "IcTinF3jBQJBAPErTwBKvHznU9dC0eY+JRpwm4Xb9zCNqaG/Ir5N8Gc1U0YLJh9D\n" +
                            "vRhtyT9+shwRPznklkc8DKwFaEU7HSiw9uMCQGLK9FLmG6jggN2zd3gpwlmWZRK0\n" +
                            "StueoVDMRQnPTgXpp35LJOpXOMle0EiyyPdTYYJlM5d9JKGUyyT8qi/pdwUCQQCE\n" +
                            "jp9vs6SCqsukh+/DM+lE7RwuqUbnAxZ39wzruP8oW2EYIMylZqArKzzwj3zqfHha\n" +
                            "I9CN+u2kJ5y2YNWYJhytAkA53cDUSL9Wo9pq5hw1C1SWNcimteeQmfQ8f0SMegDW\n" +
                            "fZ4rCjGczF82UpB12Cqo8SiK8xrCZAxfnSmSI248oCWe\n" +
                            "-----END RSA PRIVATE KEY-----";

        string publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDr5KvAc6JX22BdpsfQbWam8rjk\n" +
                            "wJzTC954XQzhLOPeGiAGfkPmCLYhBrmxZN6NxiseivpN9yzrRjYeccr+s3A/8q1E\n" +
                            "bdhmmM4+AxdNzATEsUxL//MSVXCaoJhGOfXswokFT8HQod9M6VMmuyDaw9iEorLa\n" +
                            "vV6J/nCmq2HIutcbbwIDAQAB\n" +
                            "-----END PUBLIC KEY-----";

        string plaintext = "I am a secret.. shhhhhh.";

        RSACryptoServiceProvider rsa = new RSACryptoServiceProvider();
        rsa.FromXmlString(RsaKeyConverter.PemToXml(publicKey));

        byte[] ciphertext = rsa.Encrypt(Encoding.UTF8.GetBytes(plaintext), true);

        rsa.FromXmlString(RsaKeyConverter.PemToXml(privateKey));

        byte[] decryptedBytes = rsa.Decrypt(ciphertext, true);

        Console.WriteLine(Encoding.UTF8.GetString(decryptedBytes));
    }
}

public static class RsaKeyConverter
{
    public static string PemToXml(string pemKey)
    {
        string[] lines = pemKey.Split('\n');
        string xmlKey = "";
        if (lines[0].Contains("PRIVATE"))
        {
            xmlKey += "<RSAKeyValue>";
            xmlKey += "<Modulus>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "Modulus")));
            xmlKey += "</Modulus>";
            xmlKey += "<Exponent>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "Exponent")));
            xmlKey += "</Exponent>";
            xmlKey += "<D>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "D")));
            xmlKey += "</D>";
            xmlKey += "<P>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "P")));
            xmlKey += "</P>";
            xmlKey += "<Q>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "Q")));
            xmlKey += "</Q>";
            xmlKey += "<DP>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "DP")));
            xmlKey += "</DP>";
            xmlKey += "<DQ>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "DQ")));
            xmlKey += "</DQ>";
            xmlKey += "<InverseQ>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "InverseQ")));
            xmlKey += "</InverseQ>";
            xmlKey += "</RSAKeyValue>";
        }
        else if (lines[0].Contains("PUBLIC"))
        {
            xmlKey += "<RSAKeyValue>";
            xmlKey += "<Modulus>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "Modulus")));
            xmlKey += "</Modulus>";
            xmlKey += "<Exponent>";
            xmlKey += Convert.ToBase64String(Convert.FromBase64String(GetKeyElement(lines, "Exponent")));
            xmlKey += "</Exponent>";
            xmlKey += "</RSAKeyValue>";
        }

        return xmlKey;
    }

    private static string GetKeyElement(string[] lines, string element)
    {
        string keyElement = "";

        foreach (string line in lines)
        {
            if (line.Contains(element))
            {
                int startIndex = line.IndexOf(element) + element.Length;
                int length = line.Length - startIndex;
                keyElement = line.Substring(startIndex, length);
                break;
            }
        }

        return keyElement.Trim();
    }
}