csharp
using System;
using RestSharp;

public class CustomDeserializer : RestSharp.Deserializers.JsonDeserializer
{
    public new T Deserialize<T>(IRestResponse response)
    {
        string str = response.Content;
        response.Content = str.Remove(0, 6);//remove )]}',\n
        return base.Deserialize<T>(response);
    }
}