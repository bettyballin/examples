csharp
using System;
using System.Net.Http;
using System.Security.Cryptography.X509Certificates;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        string aParm = "test"; // replace with your parameter value

        WebRequestHandler handler = new WebRequestHandler();
        X509Certificate certificate = GetMyX509Certificate();
        handler.ClientCertificates.Add(certificate);
        HttpClient client = new HttpClient(handler);
        var request = new HttpRequestMessage(HttpMethod.Get, "myapi/?myParm=" + aParm);
        HttpResponseMessage response = await client.SendAsync(request);
        response.EnsureSuccessStatusCode();
    }

    static X509Certificate GetMyX509Certificate()
    {
        // implement your logic to get the X509 certificate
        throw new NotImplementedException();
    }
}