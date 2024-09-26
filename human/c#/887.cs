csharp
using System;
using System.Windows.Forms;

public class Program
{
    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);

        var form = new Form();
        form.FormClosing += (sender, e) =>
        {
            foreach (Control control in form.Controls)
            {
                if (control is TextBox textBox && (textBox.PasswordChar == '\0' || textBox.PasswordChar == '*'))
                {
                    textBox.Text = string.Empty;
                }
            }
        };

        Application.Run(form);
    }
}