Here is the executable code:

csharp
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Security.Cryptography;

namespace DataProtectionTest
{
    public class Form1 : Form
    {
        private static readonly byte[] entropy = { 1, 2, 3, 4, 1, 2, 3, 4 };
        private string password;

        private TextBox textBox1;
        private TextBox textBox2;
        private Button btnEncryptIt;
        private Button btnDecryptIt;

        public Form1()
        {
            textBox1 = new TextBox { Location = new Point(10, 10), Size = new Size(200, 20) };
            textBox2 = new TextBox { Location = new Point(10, 40), Size = new Size(200, 20) };
            btnEncryptIt = new Button { Location = new Point(220, 10), Text = "Encrypt" };
            btnDecryptIt = new Button { Location = new Point(220, 40), Text = "Decrypt" };

            btnEncryptIt.Click += btnEncryptIt_Click;
            btnDecryptIt.Click += btnDecryptIt_Click;

            Controls.Add(textBox1);
            Controls.Add(textBox2);
            Controls.Add(btnEncryptIt);
            Controls.Add(btnDecryptIt);
        }

        private void btnEncryptIt_Click(object sender, EventArgs e)
        {
            Byte[] pw = Encoding.Unicode.GetBytes(textBox1.Text);
            Byte[] encryptedPw = ProtectedData.Protect(pw, entropy, DataProtectionScope.LocalMachine);
            password = Convert.ToBase64String(encryptedPw);
        }

        private void btnDecryptIt_Click(object sender, EventArgs e)
        {
            Byte[] pwBytes = Convert.FromBase64String(password);
            try
            {
                Byte[] decryptedPw = ProtectedData.Unprotect(pwBytes, entropy, DataProtectionScope.LocalMachine);
                string pw = Encoding.Unicode.GetString(decryptedPw);
                textBox2.Text = pw;
            }
            catch (CryptographicException ce)
            {
                textBox2.Text = ce.Message;
            }
        }

        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}