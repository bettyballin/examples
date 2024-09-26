csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Windows.Forms;

public class PBKDF2
{
    public byte[] GenerateDerivedKey(int dkLen, byte[] password, byte[] salt, int iterations)
    {
        using (var deriveBytes = new Rfc2898DeriveBytes(password, salt, iterations))
        {
            return deriveBytes.GetBytes(dkLen);
        }
    }
}

public class Form1 : Form
{
    private TextBox txtSalt;
    private TextBox txtPassword;
    private TextBox txtResult;
    private Button cmdDeriveKey;

    public Form1()
    {
        txtSalt = new TextBox { Location = new System.Drawing.Point(10, 10) };
        txtPassword = new TextBox { Location = new System.Drawing.Point(10, 40) };
        txtResult = new TextBox { Location = new System.Drawing.Point(10, 70) };
        cmdDeriveKey = new Button { Location = new System.Drawing.Point(10, 100), Text = "Derive Key" };

        cmdDeriveKey.Click += cmdDeriveKey_Click;

        this.Controls.Add(txtSalt);
        this.Controls.Add(txtPassword);
        this.Controls.Add(txtResult);
        this.Controls.Add(cmdDeriveKey);
    }

    private void cmdDeriveKey_Click(object sender, EventArgs e)
    {
        byte[] salt = Encoding.UTF8.GetBytes(txtSalt.Text);

        PBKDF2 passwordDerive = new PBKDF2();

        byte[] result = passwordDerive.GenerateDerivedKey(16, Encoding.UTF8.GetBytes(txtPassword.Text), salt, 1000);

        string x = "";

        for (int i = 0; i < result.Length; i++)
        {
            x += result[i].ToString("X");
        }

        txtResult.Text = x;
    }

    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);
        Application.Run(new Form1());
    }
}