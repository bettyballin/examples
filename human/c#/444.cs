csharp
using System;
using System.Security;
using System.Runtime.InteropServices;

public class SecureStringConverter
{
    [DllImport("mscorlib.dll")]
    static extern IntPtr PtrToStringBSTR(IntPtr ptr);

    public static SecureString ConvertToSecureString(string input)
    {
        SecureString secureString = new SecureString();
        foreach (char c in input)
        {
            secureString.AppendChar(c);
        }
        secureString.MakeReadOnly();
        return secureString;
    }

    public static string ConvertFromSecureString(SecureString input)
    {
        IntPtr ptr = Marshal.SecureStringToBSTR(input);
        string output = Marshal.PtrToStringBSTR(ptr);
        Marshal.ZeroFreeBSTR(ptr);
        return output;
    }

    public static void Main()
    {
        string input = "Hello, World!";
        SecureString secureString = ConvertToSecureString(input);
        string output = ConvertFromSecureString(secureString);
        Console.WriteLine(output);
    }
}