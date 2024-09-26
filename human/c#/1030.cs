csharp
using System;
using Newtonsoft.Json;

internal class JsonNetModuleInitializer
{
    [System.Runtime.CompilerServices.ModuleInitializer]
    public static void Initialize()
    {
        JsonConvert.DefaultSettings = () => new JsonSerializerSettings { MaxDepth = 128 };
    }
}