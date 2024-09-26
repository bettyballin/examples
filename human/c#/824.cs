csharp
using System;

class Program
{
    static void Main()
    {
        string apiKey = "your_base64_encoded_api_key";
        byte[] secretKeyByteArray = Convert.FromBase64String(apiKey);
        Console.WriteLine(BitConverter.ToString(secretKeyByteArray));
    }
}