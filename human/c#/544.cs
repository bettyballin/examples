csharp
using System;
using System.Windows.Forms;

public class MyClass : Form
{
    private Label lblData;

    public MyClass()
    {
        lblData = new Label();
        lblData.AutoSize = true;
        lblData.Location = new System.Drawing.Point(10, 10);
        this.Controls.Add(lblData);
    }

    protected void Foo(object o)
    {
        string strData = "Data" + o.ToString();
        lblData.Text = strData;
    }

    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);

        MyClass form = new MyClass();
        form.Foo("Test");
        Application.Run(form);
    }
}