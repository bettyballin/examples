csharp
using System;
using System.Net;
using System.Net.Security;
using System.Security.Cryptography.X509Certificates;

class Program
{
    // Encoded RSAPublicKey
    private static String PUB_KEY = "30818902818100C4A06B7B52F8D17DC1CCB47362" +
        "C64AB799AAE19E245A7559E9CEEC7D8AA4DF07CB0B21FDFD763C63A313A668FE9D764E" +
        "D913C51A676788DB62AF624F422C2F112C1316922AA5D37823CD9F43D1FC54513D14B2" +
        "9E36991F08A042C42EAAEEE5FE8E2CB10167174A359CEBF6FACC2C9CA933AD403137EE" +
        "2C3F4CBED9460129C72B0203010001";

    public static void Main(string[] args)
    {
        ServicePointManager.ServerCertificateValidationCallback = PinPublicKey;
        WebRequest wr = WebRequest.Create("https://encrypted.google.com/");
        wr.GetResponse();
    }

    public static bool PinPublicKey(object sender, X509Certificate certificate, X509Chain chain,
                                    SslPolicyErrors sslPolicyErrors)
    {
        if (null == certificate)
            return false;

        String pk = certificate.GetPublicKeyString();
        if (pk.Equals(PUB_KEY))
            return true;

        // Bad dog
        return false;
    }
}