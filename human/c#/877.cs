csharp
using System;
using System.Collections.Generic;
using Newtonsoft.Json.Linq;

class Program
{
    static void Main()
    {
        var json = @"
        {
            ""NestedInThisObject"": {
                ""Student"": ""John Doe""
            }
        }";

        var parsedObject = JObject.Parse(json);

        Console.WriteLine(parsedObject["NestedInThisObject"]["Student"].ToString());
    }
}