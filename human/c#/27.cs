csharp
using System;
using System.Runtime.InteropServices;
using System.Security;

class Program
{
    static void Main()
    {
        SecureString secureString = new SecureString();
        secureString.AppendChar('H');
        secureString.AppendChar('e');
        secureString.AppendChar('l');
        secureString.AppendChar('l');
        secureString.AppendChar('o');
        secureString.MakeReadOnly();

        Console.WriteLine(SecureStringToString(secureString));
    }

    static String SecureStringToString(SecureString value)
    {
        IntPtr valuePtr = IntPtr.Zero;
        try
        {
            valuePtr = Marshal.SecureStringToGlobalAllocUnicode(value);
            return Marshal.PtrToStringUni(valuePtr);
        }
        finally
        {
            Marshal.ZeroFreeGlobalAllocUnicode(valuePtr);
        }
    }
}