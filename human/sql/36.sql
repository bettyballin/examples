csharp
using System;
using System.Data;
using System.Data.SqlClient;

class Program
{
    static void Main()
    {
        string connectionString = "Your connection string here";
        string messageString = "Your message here";

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            DataSet userDataset = new DataSet();

            SqlCommand myCommand = new SqlCommand("SELECT * FROM Log WHERE Message = @Message", connection);
            SqlDataAdapter myDataAdapter = new SqlDataAdapter(myCommand);

            myCommand.Parameters.Add("@Message", SqlDbType.VarChar, 11);
            myCommand.Parameters["@Message"].Value = messageString;

            connection.Open();
            myDataAdapter.Fill(userDataset);
            connection.Close();
        }
    }
}