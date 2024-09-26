csharp
using System;
using Newtonsoft.Json;

class Program
{
    static void Main()
    {
        string json = "{\"Appsettings\":{\"key\":\"this is my keyss\"}}";
        dynamic appSettings = JsonConvert.DeserializeObject(json);
        Console.WriteLine(appSettings.Appsettings.key);
    }
}