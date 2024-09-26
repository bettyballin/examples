csharp
using System;
using System.Windows.Controls;

public class User
{
    public string EncryptedPassword { get; set; }
}

public class SomeLibrary
{
    public static string EncryptValue(string value, string key)
    {
        // Your encryption logic here
        return value; // Replace with actual encryption
    }
}

public partial class MainWindow : Window
{
    private User _user;
    private string someKey = "yourKey";

    public MainWindow()
    {
        InitializeComponent();
        _user = new User { EncryptedPassword = "encryptedPassword" };
    }

    private void Login(object sender, RoutedEventArgs e)
    {
        PasswordBox pwBox = sender as PasswordBox;
        var encryptedPassword = SomeLibrary.EncryptValue(pwBox.Password, someKey);

        if (encryptedPassword == _user.EncryptedPassword)
        {
            MessageBox.Show("Login Successful");
        }
        else
        {
            MessageBox.Show("Invalid Password");
        }
    }
}