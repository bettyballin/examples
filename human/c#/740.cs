csharp
using System;
using System.Security.Cryptography.X509Certificates;
using System.Configuration;
using System.Convert;

var certText = ConfigurationManager.AppSettings["SigningCertificate"];
var certPassword = ConfigurationManager.AppSettings["SigningCertificatePassword"];
var certBytes = Convert.FromBase64String(certText);

var certificate = new X509Certificate2(certBytes, certPassword);

var options = new IdentityServerOptions
{
    SigningCertificate = certificate,
    RequireSsl = false, 
    Factory = factory
};