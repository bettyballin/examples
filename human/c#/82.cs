csharp
using System;
using System.IO;
using System.Net;
using System.Text;

class Program
{
    static void Main()
    {
        string url = "http://example.com/soap/service";
        string xml = "<soap:Envelope xmlns:soap='http://www.w3.org/2003/05/soap-envelope/'>...</soap:Envelope>";
        PostXml(url, xml);
    }

    public static void PostXml(string url, string xml)
    {
        byte[] bytes = Encoding.UTF8.GetBytes(xml);
        HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
        request.Method = "POST";
        request.ContentLength = bytes.Length;
        request.ContentType = "text/xml";

        using (Stream requestStream = request.GetRequestStream())
        {
            requestStream.Write(bytes, 0, bytes.Length);
        }

        using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
        {
            if (response.StatusCode != HttpStatusCode.OK)
            {
                string message = String.Format("POST failed with HTTP {0}", 
                                               response.StatusCode);
                throw new ApplicationException(message);
            }
        }
    }
}