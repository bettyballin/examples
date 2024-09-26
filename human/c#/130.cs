csharp
using System;
using System.Data;
using System.Data.SqlClient;

class Program
{
    static void Main()
    {
        string connectionString = "Data Source=<Your Server Name>;Initial Catalog=<Your Database Name>;User ID=<Your User ID>;Password=<Your Password>;";
        Int32 customerID = 1;
        string demoXml = "<Demographics><StoreSurvey><AnnualSales>300000</AnnualSales><AnnualRevenue>150000</AnnualRevenue></StoreSurvey></Demographics>";

        UpdateDemographics(customerID, demoXml, connectionString);
    }

    private static void UpdateDemographics(Int32 customerID, string demoXml, string connectionString)
    {
        string commandText = "UPDATE Sales.Store SET Demographics = @demographics WHERE CustomerID = @ID;";

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            SqlCommand command = new SqlCommand(commandText, connection);
            command.Parameters.Add("@ID", SqlDbType.Int);
            command.Parameters["@ID"].Value = customerID;

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
}