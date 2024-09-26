csharp
using System;
using System.Collections;
using System.Reflection;

class Program
{
    static void Main()
    {
        var mapField = typeof(Org.BouncyCastle.Cms.CmsSignedData).Assembly.GetType("Org.BouncyCastle.Cms.CmsSignedHelper").GetField("digestAlgs", BindingFlags.Static | BindingFlags.NonPublic);
        var map = (IDictionary)mapField.GetValue(null);
        foreach (DictionaryEntry entry in map)
        {
            Console.WriteLine(entry.Key + ": " + entry.Value);
        }
    }
}