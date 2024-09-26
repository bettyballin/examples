csharp
using System;

class CertificateValidator 
{
    public static bool ValidateCertificate() 
    {
        // When processing reaches this line, the only errors in the certificate chain are 
        // untrusted root errors for self-signed certificates. These certificates are valid
        // for default Exchange server installations, so return true.

        // Or when you know that the certificate is signed by a trusted root authority, return false.
        return false;
    }

    public static void Main(string[] args) 
    {
        Console.WriteLine(ValidateCertificate());
    }
}