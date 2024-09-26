csharp
using System;
using System.Windows.Forms;

public class Program : Form
{
    private Label lblData;

    public Program()
    {
        lblData = new Label();
        lblData.AutoSize = true;
        this.Controls.Add(lblData);
    }

    protected void Foo(object o)
    {
        string strData = "Data" + o.ToString();
        validateStrData(strData);
        lblData.Text = strData;
    }

    private void validateStrData(string strData)
    {
        //some validating logic
        if (strData.Length > 10)
        {
            throw new ArgumentException("String too long");
        }
    }

    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);
        Program program = new Program();
        program.Foo(" Test");
        Application.Run(program);
    }
}