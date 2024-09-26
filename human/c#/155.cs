Here's the executable code:

csharp
using System;
using System.Data.Odbc;

public class SqlQuery
{
    public const string INBOUND_UPDATE_CALLBACK_NUM = "UPDATE_INBOUND_CALLBACK_NUM";

    public static string GetQueryText(string queryKey)
    {
        switch (queryKey)
        {
            case INBOUND_UPDATE_CALLBACK_NUM:
                return "UPDATE Inbound SET CallbackNum = @CallbackNum WHERE Id = @Id";
            default:
                throw new ArgumentException("Unknown query key", nameof(queryKey));
        }
    }
}

class Program
{
    static void Main()
    {
        string connectionString = "DRIVER={ODBC Driver};SERVER=your_server;DATABASE=your_database;UID=your_username;PWD=your_password";
        string queryText = SqlQuery.GetQueryText(SqlQuery.INBOUND_UPDATE_CALLBACK_NUM);

        using (OdbcConnection con = new OdbcConnection(connectionString))
        {
            con.Open();

            using (OdbcCommand cmd = new OdbcCommand(queryText, con))
            {
                cmd.Parameters.AddWithValue("@CallbackNum", "1234567890");
                cmd.Parameters.AddWithValue("@Id", 1);
                cmd.ExecuteNonQuery();
            }
        }
    }
}