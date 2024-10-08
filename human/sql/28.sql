csharp
using System;
using System.Data;
using System.Data.SqlClient;

public class Program
{
    private static void UpdateDemographics(Int32 customerID, string demoXml, string connectionString)
    {
        // Update the demographics for a store, which is stored 
        // in an xml column. 
        string commandText = "UPDATE Sales.Store SET Demographics = @demographics "
            + "WHERE CustomerID = @ID;";

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            SqlCommand command = new SqlCommand(commandText, connection);
            command.Parameters.Add("@ID", SqlDbType.Int);
            command.Parameters["@ID"].Value = customerID;

            // Use AddWithValue to assign Demographics.
            // SQL Server will implicitly convert strings into XML.
            command.Parameters.AddWithValue("@demographics", demoXml);

            try
            {
                connection.Open();
                Int32 rowsAffected = command.ExecuteNonQuery();
                Console.WriteLine("RowsAffected: {0}", rowsAffected);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }

    public static void Main(string[] args)
    {
        string connectionString = "Server=myServerAddress;Database=myDataBase;User Id=myUsername;Password=myPassword;";
        Int32 customerID = 1;
        string demoXml = "<Demographics><City>Redmond</City><State>WA</State></Demographics>";

        UpdateDemographics(customerID, demoXml, connectionString);
    }
}