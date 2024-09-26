csharp
using System;
using System.Text;
using System.Runtime.InteropServices;

public class Program
{
    [DllImport("advapi32.dll", CharSet = CharSet.Auto, SetLastError = true)]
    static extern IntPtr RngInitialize(byte[] seed);

    public static void Main()
    {
        string str = "Your Seed String Here";
        IntPtr _handle = RngInitialize(Encoding.UTF8.GetBytes(str));
    }
}