csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        string strLicenseString = "Your license string here";
        byte[] buffer = Encoding.UTF8.GetBytes(strLicenseString);
        Console.WriteLine(BitConverter.ToString(buffer));
    }
}