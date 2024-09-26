csharp
using System.Windows;

namespace WpfApp
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Options_Click(object sender, RoutedEventArgs e)
        {
            txtCover.Text = "text ...........";
        }
    }
}