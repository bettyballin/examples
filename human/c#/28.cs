csharp
using System;
using System.Runtime.InteropServices;
using System.Security;

class Program
{
    static void Main()
    {
        using (SecureString secureString = new SecureString())
        {
            secureString.AppendChar('H');
            secureString.AppendChar('e');
            secureString.AppendChar('l');
            secureString.AppendChar('l');
            secureString.AppendChar('o');
            secureString.MakeReadOnly();
            HandleSecureString(secureString);
        }
    }

    static void HandleSecureString(SecureString value)
    {
        IntPtr valuePtr = IntPtr.Zero;
        try
        {
            valuePtr = Marshal.SecureStringToGlobalAllocUnicode(value);
            for (int i = 0; i < value.Length; i++)
            {
                short unicodeChar = Marshal.ReadInt16(valuePtr, i * 2);
                Console.Write((char)unicodeChar);
            }
        }
        finally
        {
            Marshal.ZeroFreeGlobalAllocUnicode(valuePtr);
        }
    }
}