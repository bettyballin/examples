csharp
using System;
using System.Data.SqlClient;

public class LoginChecker
{
    private string _ConnectionString;

    public LoginChecker(string connectionString)
    {
        _ConnectionString = connectionString;
    }

    public bool CheckLogin(string name, string password)
    {
        using (SqlConnection objConnection = new SqlConnection(_ConnectionString))
        {
            objConnection.Open();

            using (SqlCommand objCommand = new SqlCommand(
                "SELECT * FROM User WHERE Name = @Name AND Password = @Password",
                objConnection))
            {
                objCommand.Parameters.AddWithValue("@Name", name);
                objCommand.Parameters.AddWithValue("@Password", password);

                using (SqlDataReader objReader = objCommand.ExecuteReader())
                {
                    return objReader.Read();
                }
            }
        }
    }
}

public class Program
{
    public static void Main()
    {
        string connectionString = "your_connection_string";
        LoginChecker loginChecker = new LoginChecker(connectionString);
        string name = "John";
        string password = "your_password";

        if (loginChecker.CheckLogin(name, password))
        {
            Console.WriteLine("Login successful.");
        }
        else
        {
            Console.WriteLine("Login failed.");
        }
    }
}