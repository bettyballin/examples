This is not C# code, but an XML configuration file. Here is a simple C# program that reads the connection strings from the configuration file:

csharp
using System;
using System.Configuration;

class Program
{
    static void Main()
    {
        string connectionString = ConfigurationManager.ConnectionStrings["YourConnectionStringName"].ConnectionString;
        Console.WriteLine(connectionString);
    }
}


xml
<?xml version='1.0' encoding='utf-8'?>
<configuration>
    <connectionStrings configSource="connections.config"/>
</configuration>


xml
<!-- connections.config -->
<connectionStrings>
    <add name="YourConnectionStringName" connectionString="YourConnectionString" providerName="System.Data.SqlClient"/>
</connectionStrings>