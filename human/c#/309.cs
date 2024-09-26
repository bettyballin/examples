csharp
using System;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using MySql.Data.MySqlClient;

public partial class Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
    }

    protected void OnLoginClick(object sender, EventArgs e)
    {
        string username = txtUsername.Text;
        string pass = txtPassword.Text;

        if (MySqlValidUser(username, pass))
        {
            FormsAuthentication.SetAuthCookie(username, null);
            Response.Redirect("/");
        }
    }

    private bool MySqlValidUser(string username, string pass)
    {
        string connectionString = "Server=myServerAddress;Database=myDataBase;User Id=myUsername;Password=myPassword;";
        string query = "SELECT * FROM Users WHERE Username = @Username AND Password = @Password";

        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            connection.Open();

            MySqlCommand command = new MySqlCommand(query, connection);
            command.Parameters.AddWithValue("@Username", username);
            command.Parameters.AddWithValue("@Password", pass);

            MySqlDataReader reader = command.ExecuteReader();
            if (reader.HasRows)
            {
                reader.Close();
                return true;
            }
            else
            {
                reader.Close();
                return false;
            }
        }
    }
}