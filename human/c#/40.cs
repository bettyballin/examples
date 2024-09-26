csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        CustomBinding binding = new CustomBinding();
        binding.Name = "customMex";

        TextMessageEncodingBindingElement textEncoding = new TextMessageEncodingBindingElement();
        textEncoding.ReaderQuotas.MaxDepth = 2147483647;
        textEncoding.ReaderQuotas.MaxStringContentLength = 2147483647;
        textEncoding.ReaderQuotas.MaxArrayLength = 2147483647;
        textEncoding.ReaderQuotas.MaxBytesPerRead = 2147483647;
        textEncoding.ReaderQuotas.MaxNameTableCharCount = 2147483647;

        HttpTransportBindingElement httpTransport = new HttpTransportBindingElement();
        httpTransport.TransferMode = TransferMode.Buffered;
        httpTransport.MaxReceivedMessageSize = 2147483647;
        httpTransport.MaxBufferSize = 2147483647;

        binding.Elements.Add(textEncoding);
        binding.Elements.Add(httpTransport);

        Console.WriteLine(binding.ToString());
    }
}