csharp
using System;
using System.Windows.Forms;
using XenSnapshotsXenAccess;

namespace Create_XenSnapshotsUi
{
    public partial class Form1 : Form
    {
        XenSessionAccess xenSession = null;

        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            xenSession = new XenSessionAccess("https://xxx.xx.x.x", @"C:\foo\xml_credentials.xml");
            xenSession.Logout();
        }
    }
}