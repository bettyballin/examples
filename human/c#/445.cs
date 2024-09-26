csharp
using System;
using System.Reflection;
using System.Security.Claims;

public class ClaimsPrincipalPermission : Attribute
{
    public int AccountId { get; set; }
}

public class YourClassType
{
    [ClaimsPrincipalPermission]
    public void ViewTransaction()
    {
        // Method implementation
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        var method = typeof(YourClassType).GetMethod("ViewTransaction");
        var attribute = method.GetCustomAttribute(typeof(ClaimsPrincipalPermission)) as ClaimsPrincipalPermission;
        attribute.AccountId = 1234;
    }
}