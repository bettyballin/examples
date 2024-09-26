csharp
using System;
using System.Linq;
using Microsoft.Owin;

public class Program
{
    public static void Main()
    {
        var context = new OwinContext();
        var uid = context.Parameters.Where(f => f.Key == "uid").Select(f => f.Value).SingleOrDefault();
        if (uid != null && uid.Length > 0)
        {
            context.Set<string>("SmartCard", uid[0]);
        }
    }
}