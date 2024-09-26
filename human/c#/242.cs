csharp
using System;
using System.Data.SqlClient;

class Program
{
    static void Main()
    {
        string UserName = "your_username";
        string Password = "your_password";

        using (SqlConnection con = new SqlConnection("Data Source=MICROSOF-58B8A5\\SQL_SERVER_R2;Initial Catalog=Daniel;Integrated Security=True"))
        {
            string query = "SELECT TOP 1 Username FROM Users WHERE Username=@UserName AND Password=@Password";

            using (SqlCommand command = new SqlCommand(query, con))
            {
                command.Parameters.AddWithValue("@UserName", UserName);
                command.Parameters.AddWithValue("@Password", Password);
                con.Open();
                object result = command.ExecuteScalar();
                string username = result != null ? (string)result : null;
                if (username != null)
                {
                    Console.WriteLine("Username exists: " + username);
                    // Do stuff if username exists
                }
                else
                {
                    Console.WriteLine("Username does not exist");
                }
            }
        }
    }
}