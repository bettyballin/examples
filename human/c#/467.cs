csharp
using System;
using System.Data.SqlClient;

class Program
{
    static void Main()
    {
        string connectionString = "Server=myServer;Database=Test;User Id=myUser;Password=myPassword;";
        string query = @"
            GRANT EXECUTE ON SchemaB.GetCustomerOrderInfo TO UserC
            EXECUTE AS LOGIN = 'UserC'
            EXEC SchemaB.GetCustomerOrderInfo 
            -- The SELECT permission was denied on the object 'Customers', database 'Test', schema 'SchemaA'.
            REVERT
        ";

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            connection.Open();
            SqlCommand command = new SqlCommand(query, connection);
            command.ExecuteNonQuery();
        }
    }
}