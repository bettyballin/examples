csharp
using System;
using System.Windows.Forms;

class Program
{
    static void Main()
    {
        try
        {
            YourFunction();
        }
        catch (System.Security.SecurityException)
        {
            MessageBox.Show("You do not have permission to perform this action.", "Access Error", MessageBoxButtons.OK, MessageBoxIcon.Stop);
        }
    }

    static void YourFunction()
    {
        // Your function code here
    }
}