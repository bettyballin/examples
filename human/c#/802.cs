csharp
using System;
using System.Security.Cryptography.X509Certificates;
using System.Net.Mail;
using System.Net.Mime;
using MimeKit;
using MimeKit.Cryptography;

class Program
{
    static void Main()
    {
        var ctx = new MimeKit.Cryptography.CryptographyContext();
        var message = new MimeMessage();
        message.Body = new TextPart("plain") { Text = "Hello, World!" };

        var signer = new CmsSigner("certificate.pfx", "password");
        signer.RsaSignaturePaddingScheme = RsaSignaturePaddingScheme.Pss;
        var signed = MultipartSigned.Create(ctx, signer, message.Body);
        message.Body = signed;

        Console.WriteLine(message.ToString());
    }
}