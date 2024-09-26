csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        byte[] rawData = { /* your raw certificate data here */ };
        string password = "password";

        X509Certificate2 cert = new X509Certificate2(rawData, password);
        X509Certificate2 cert2 = new X509Certificate2(rawData, password,
              X509KeyStorageFlags.MachineKeySet |
              X509KeyStorageFlags.PersistKeySet |
              X509KeyStorageFlags.Exportable);
    }
}