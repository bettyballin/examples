csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Windows.Forms;

public class Login
{
    public void Login_click(object sender, EventArgs r)
    {
        string username = txtUsername.Text;
        string password = txtpassword.Text;

        if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
        {
            MessageBox.Show("Please enter both username and password.");
            return;
        }

        User user = GetUserByUsername(username);

        if (user == null)
        {
            MessageBox.Show("User not found.");
            return;
        }

        bool isPasswordMatched = VerifyPassword(password, user.Hash, user.Salt);

        if (isPasswordMatched)
        {
            MessageBox.Show("Login successful.");
            // Additional logic for successful login
        }
        else
        {
            MessageBox.Show("Incorrect username or password.");
        }
    }

    private User GetUserByUsername(string username)
    {
        // Assuming a database or storage connection
        // Replace with actual database call
        // For demonstration purposes, a dummy user is returned
        return new User
        {
            Username = "test",
            Hash = "hashed_password",
            Salt = "password_salt"
        };
    }

    private bool VerifyPassword(string password, string hash, string salt)
    {
        // Create a new salted hash
        string newHash = GenerateHash(password, salt);

        // Compare the new hash with the stored hash
        return newHash.Equals(hash);
    }

    private string GenerateHash(string password, string salt)
    {
        using (var sha256 = SHA256.Create())
        {
            var bytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password + salt));
            var builder = new StringBuilder();

            foreach (var b in bytes)
            {
                builder.Append(b.ToString("x2"));
            }

            return builder.ToString();
        }
    }
}

public class User
{
    public string Username { get; set; }
    public string Hash { get; set; }
    public string Salt { get; set; }
}