csharp
using System;
using System.Runtime.InteropServices;
using System.Security;

public class SecureStringComparer
{
    public static Boolean SecureStringEqual(SecureString secureString1, SecureString secureString2)
    {
        if (secureString1 == null)
        {
            throw new ArgumentNullException("s1");
        }
        if (secureString2 == null)
        {
            throw new ArgumentNullException("s2");
        }

        if (secureString1.Length != secureString2.Length)
        {
            return false;
        }

        IntPtr ss_bstr1_ptr = IntPtr.Zero;
        IntPtr ss_bstr2_ptr = IntPtr.Zero;

        try
        {
            ss_bstr1_ptr = Marshal.SecureStringToBSTR(secureString1);
            ss_bstr2_ptr = Marshal.SecureStringToBSTR(secureString2);

            String str1 = Marshal.PtrToStringBSTR(ss_bstr1_ptr);
            String str2 = Marshal.PtrToStringBSTR(ss_bstr2_ptr);

            return str1.Equals(str2);
        }
        finally
        {
            if (ss_bstr1_ptr != IntPtr.Zero)
            {
                Marshal.ZeroFreeBSTR(ss_bstr1_ptr);
            }

            if (ss_bstr2_ptr != IntPtr.Zero)
            {
                Marshal.ZeroFreeBSTR(ss_bstr2_ptr);
            }
        }
    }

    public static void Main()
    {
        using (var ss1 = new SecureString())
        {
            ss1.AppendChar('p');
            ss1.AppendChar('a');
            ss1.AppendChar('s');
            ss1.AppendChar('s');
            ss1.AppendChar('w');
            ss1.AppendChar('o');
            ss1.AppendChar('r');
            ss1.AppendChar('d');

            using (var ss2 = new SecureString())
            {
                ss2.AppendChar('p');
                ss2.AppendChar('a');
                ss2.AppendChar('s');
                ss2.AppendChar('s');
                ss2.AppendChar('w');
                ss2.AppendChar('o');
                ss2.AppendChar('r');
                ss2.AppendChar('d');

                Console.WriteLine(SecureStringEqual(ss1, ss2)); // True
            }
        }
    }
}