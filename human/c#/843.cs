csharp
using System;
using System.Security.Cryptography;
using System.Data.SqlClient;
using System.Data;

public class HashSalt
{
    public string Hash { get; set; }
    public string Salt { get; set; }
}

public class Program
{
    public static HashSalt GenerateSaltedHash(int saltSize, string password)
    {
        var saltBytes = new byte[saltSize / 8];
        using (var rng = RandomNumberGenerator.Create())
        {
            rng.GetBytes(saltBytes);
        }

        using (var pbkdf2 = new Rfc2898DeriveBytes(password, saltBytes, 100000))
        {
            var hashBytes = pbkdf2.GetBytes(32);
            var hash = Convert.ToBase64String(hashBytes);
            var salt = Convert.ToBase64String(saltBytes);
            return new HashSalt { Hash = hash, Salt = salt };
        }
    }

    public void Submit1_click(object sender, EventArgs e)
    {
        string connectionString = "Your Connection String";
        string query = "Your Query";

        using (SqlConnection con = new SqlConnection(connectionString))
        {
            con.Open();
            using (SqlCommand cmd = new SqlCommand(query, con))
            {
                HashSalt hashSalt = GenerateSaltedHash(64, password1.Text);

                cmd.Parameters.AddWithValue("@hash", hashSalt.Hash);
                cmd.Parameters.AddWithValue("@salt", hashSalt.Salt);

                cmd.ExecuteNonQuery();
            }
        }
    }
}