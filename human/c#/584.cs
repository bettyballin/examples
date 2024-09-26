csharp
using System;
using RestSharp;
using RestSharp.Deserializers;

public class MyDeserializer : IDeserializer
{
    public T Deserialize<T>(IRestResponse response)
    {
        // implement your deserialization logic here
        // for simplicity, I'm using the built-in JsonDeserializer
        return new JsonDeserializer().Deserialize<T>(response);
    }
}

public class UserGuamInformations
{
    // define the properties of the UserGuamInformations class
}

class Program
{
    static void Main()
    {
        var client = new RestClient("https://api.example.com");
        var request = new RestRequest("users/guam/informations", Method.GET);

        var result = client.Execute(request);
        var u = new MyDeserializer().Deserialize<UserGuamInformations>(result);

        Console.WriteLine("Deserialized result:");
        Console.WriteLine(u.ToString());
    }
}