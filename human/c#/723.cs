csharp
using System;
using System.Dynamic;
using System.Linq;
using System.Management;

public static class WMI
{
    public static dynamic[] Query(string q)
    {
        using (var s = new ManagementObjectSearcher(q))
            return
                s
                .Get()
                .OfType<ManagementObject>()
                .Select(i => {
                    var x = new ExpandoObject();
                    using (i) foreach (var p in i.Properties) (x as IDictionary<string, object>).Add(p.Name, p.Value);
                    return x;
                })
                .ToArray();
    }

    public static void Main(string[] args)
    {
        var results = WMI.Query("SELECT * FROM Win32_OperatingSystem");
        foreach (var result in results)
        {
            Console.WriteLine(string.Join(", ", result));
        }
    }
}