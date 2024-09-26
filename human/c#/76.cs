csharp
using System;
using System.Data.SqlClient;
using System.Security;

class Program
{
    static void Main()
    {
        SecureString pwd = AzureVault.GetSecretStringSecure("ProcessPassword");
        SqlCredential cred = new SqlCredential("Richard", pwd);
        SqlConnection connection = new SqlConnection("Your Connection String");
        connection.Credential = cred;
        connection.Open();
        Console.WriteLine("Connected to database");
        connection.Close();
    }
}