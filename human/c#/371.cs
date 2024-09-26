csharp
using System;
using System.Windows;
using System.Windows.Controls;

public class SomeBlackBoxClass
{
    public static void ValidatePassword(string username, string password)
    {
        // Your password validation logic here
        Console.WriteLine($"Username: {username}, Password: {password}");
    }
}

public partial class MainWindow : Window
{
    public string UserName { get; set; }

    public MainWindow()
    {
        InitializeComponent();
        UserName = "TestUser";
    }

    private void Login(object sender, RoutedEventArgs e)
    {
        PasswordBox pwBox = sender as PasswordBox;
        SomeBlackBoxClass.ValidatePassword(UserName, pwBox.Password);
    }
}

// XAML
<Window x:Class="YourNamespace.MainWindow"
        xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
        xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml"
        Title="Login" Height="150" Width="300">
    <StackPanel>
        <PasswordBox x:Name="passwordBox" PasswordChar="*" Margin="5" />
        <Button Content="Login" Click="Login" Margin="5" />
    </StackPanel>
</Window>