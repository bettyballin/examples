csharp
using System;
using System.Data.Common;

public class Program
{
    public static string CensorConnectionString(string connectionString)
    {
        var builder = new DbConnectionStringBuilder() { ConnectionString = connectionString };
        if (builder.ContainsKey("password"))
        {
            builder["password"] = "*****";
        }
        return builder.ToString();
    }

    public static void Main()
    {
        string connectionString = "Server=myServerAddress;Database=myDataBase;User Id=myUsername;Password=myPassword;";
        Console.WriteLine("Original Connection String: " + connectionString);
        Console.WriteLine("Censored Connection String: " + CensorConnectionString(connectionString));
    }
}