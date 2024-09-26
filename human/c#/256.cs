csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        string certificatePath = "path_to_your_certificate";
        string certificatePassword = "your_certificate_password";

        X509Certificate2 cert = new X509Certificate2(certificatePath,
                                                    certificatePassword,
                                                    X509KeyStorageFlags.MachineKeySet);
    }
}