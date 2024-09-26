This code is not C# code, it's SQL Server T-SQL code. To make it executable, you would need to run it in a SQL Server environment, such as SQL Server Management Studio or a similar tool.

However, if you want to execute this code from a C# application, you would need to use the `System.Data.SqlClient` namespace and create a connection to your SQL Server instance. Here is an example:

csharp
using System;
using System.Data.SqlClient;

class Program
{
    static void Main()
    {
        string connectionString = "Server=myServerAddress;Database=myDataBase;User Id=myUsername;Password=myPassword;";
        string sql = @"
            if exists (select * from sys.syslogins where name = 'UserA')
                drop login UserA 
            create login UserA with password = 'Welcome'
            if exists (select * from sys.syslogins where name = 'UserB')
                drop login UserB 
            create login UserB with password = 'Welcome'
            if exists (select * from sys.syslogins where name = 'UserC')
                drop login UserC 
            create login UserC with password = 'Welcome'

            if exists (select * from sys.tables where name = 'Customers' and schema_name(schema_id) = 'SchemaA')
                drop table SchemaA.Customers
            if exists (select * from sys.schemas where name = 'SchemaA')
                drop schema SchemaA
            if exists (select * from sys.sysusers where name = 'UserA')
                drop user UserA

            if exists (select * from sys.tables where name = 'Orders' and schema_name(schema_id) = 'SchemaB')
                drop table SchemaB.Orders
            if exists (select * from sys.procedures where name = 'GetCustomerOrderInfo' and schema_name(schema_id) = 'SchemaB')
                drop procedure SchemaB.GetCustomerOrderInfo 
            if exists (select * from sys.schemas where name = 'SchemaB')
                drop schema SchemaB
            if exists (select * from sys.sysusers where name = 'UserB')
                drop user UserB

            if exists (select * from sys.sysusers where name = 'UserC')
                drop user UserC

            create user UserA for login UserA
            alter role db_owner add member UserA
            go
            create schema SchemaA authorization UserA
            go
            create user UserB for login UserB
            alter role db_owner add member UserB
            go
            create schema SchemaB authorization UserB
            go
            create user UserC for login UserC

            create table SchemaA.Customers (id int identity)

            create table SchemaB.Orders (id int identity, CustomerId int)
            go
            create procedure SchemaB.GetCustomerOrderInfo 
            as
            select  *
            from    SchemaB.Orders o
            join    SchemaA.Customers c
            on      c.id = o.CustomerId
            go";

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            connection.Open();
            string[] commands = sql.Split(new[] { "go" }, StringSplitOptions.RemoveEmptyEntries);
            foreach (string command in commands)
            {
                using (SqlCommand cmd = new SqlCommand(command, connection))
                {
                    cmd.ExecuteNonQuery();
                }
            }
        }
    }
}