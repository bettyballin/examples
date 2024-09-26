csharp
using Org.BouncyCastle.Utilities.IO.Pem;
using System.IO;

class Program
{
    static void Main()
    {
        byte[] privatePkcs8Der = File.ReadAllBytes("private_key.der");

        StringWriter stringWriter = new StringWriter();
        PemWriter pemWriter = new PemWriter(stringWriter);
        pemWriter.WriteObject((PemObjectGenerator)new PemObject("PRIVATE KEY", privatePkcs8Der));
        pemWriter.Flush();
        Console.WriteLine(stringWriter.ToString());
    }
}