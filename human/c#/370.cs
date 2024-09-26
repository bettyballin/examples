csharp
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

public class LoginViewModel
{
    public ICommand LoginCommand { get; set; }

    public LoginViewModel()
    {
        LoginCommand = new RelayCommand(Login);
    }

    private void Login(object parameter)
    {
        var passwordBox = parameter as PasswordBox;
        if (passwordBox != null)
        {
            var password = passwordBox.Password;
            // Perform login logic here
            MessageBox.Show("Login button clicked with password: " + password);
        }
    }
}

public class RelayCommand : ICommand
{
    private readonly Action<object> _execute;

    public RelayCommand(Action<object> execute)
    {
        _execute = execute;
    }

    public bool CanExecute(object parameter)
    {
        return true;
    }

    public void Execute(object parameter)
    {
        _execute(parameter);
    }

    public event EventHandler CanExecuteChanged;
}

public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
        DataContext = new LoginViewModel();
    }
}

<Window x:Class="WpfApp.MainWindow"
        xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
        xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml"
        Title="Login" Height="200" Width="300">
    <Grid>
        <PasswordBox Name="MyPasswordBox" Width="200" Height="25" Margin="10"/>
        <Button Content="Login" 
                Command="{Binding LoginCommand}" 
                CommandParameter="{Binding ElementName=MyPasswordBox}" 
                Margin="10" VerticalAlignment="Bottom"/>
    </Grid>
</Window>