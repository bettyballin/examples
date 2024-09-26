csharp
using System;
using System.Web.Routing;

public static class RouteExtensions
{
    public static string GetAreaName(this RouteData routeData)
    {
        object value;
        if (routeData.DataTokens.TryGetValue("area", out value))
        {
            return (value as string);
        }
        return GetAreaName(routeData.Route);
    }

    public static string GetAreaName(this RouteBase route)
    {
        var areaRoute = route as IRouteWithArea;
        if (areaRoute != null)
        {
            return areaRoute.Area;
        }

        var standardRoute = route as Route;
        if ((standardRoute != null) && (standardRoute.DataTokens != null))
        {
            return (standardRoute.DataTokens["area"] as string) ?? string.Empty;
        }

        return string.Empty;
    }
}

class Program
{
    static void Main()
    {
        var routeData = new RouteData();
        routeData.DataTokens.Add("area", "TestArea");
        Console.WriteLine(routeData.GetAreaName());

        var route = new Route("{controller}/{action}");
        route.DataTokens.Add("area", "TestArea2");
        Console.WriteLine(route.GetAreaName());
    }
}