csharp
using System;
using System.IO;
using System.Security.AccessControl;
using System.Windows.Forms;

public class FileSecurityEditor
{
    public void RemoveFileSecurityRule(string path, ListView listView1)
    {
        AuthorizationRuleCollection rules = File.GetAccessControl(path).GetAccessRules(true, true, typeof(System.Security.Principal.NTAccount));

        foreach (FileSystemAccessRule rule in rules)
        {
            if (rule.IdentityReference.Value == listView1.SelectedItems[0].Text)
            {
                RemoveFileSecurity(path, rule);
                MessageBox.Show("OK");
            }
        }
    }

    public static void RemoveFileSecurity(string fileName, FileSystemAccessRule rule)
    {
        FileSecurity fSecurity = File.GetAccessControl(fileName);
        fSecurity.RemoveAccessRule(rule);
        File.SetAccessControl(fileName, fSecurity);
    }

    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);
        Application.Run(new FileSecurityForm());
    }
}

public class FileSecurityForm : Form
{
    private ListView listView1;

    public FileSecurityForm()
    {
        listView1 = new ListView();
        listView1.Dock = DockStyle.Fill;
        this.Controls.Add(listView1);
        this.Load += new EventHandler(FileSecurityForm_Load);
    }

    void FileSecurityForm_Load(object sender, EventArgs e)
    {
        // populate the listview with some items
        listView1.Items.Add("Everyone");
        listView1.Items.Add("Users");
        listView1.Items.Add("Administrators");

        // select the first item
        listView1.Items[0].Selected = true;

        Button button = new Button();
        button.Text = "Remove Security Rule";
        button.Click += new EventHandler(button_Click);
        this.Controls.Add(button);
    }

    void button_Click(object sender, EventArgs e)
    {
        string path = @"C:\path\to\your\file.txt"; // replace with your file path
        FileSecurityEditor editor = new FileSecurityEditor();
        editor.RemoveFileSecurityRule(path, listView1);
    }
}