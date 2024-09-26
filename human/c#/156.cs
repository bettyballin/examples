csharp
using System;
using System.Runtime.InteropServices;
using System.Security;

class Program
{
    bool SecureStringEqual(SecureString s1, SecureString s2)  
    {  
        if (s1 == null)  
        {  
            throw new ArgumentNullException("s1");  
        }  
        if (s2 == null)  
        {  
            throw new ArgumentNullException("s2");  
        }  

        if (s1.Length != s2.Length)  
        {  
            return false;  
        }  

        IntPtr bstr1 = IntPtr.Zero;  
        IntPtr bstr2 = IntPtr.Zero;  

        RuntimeHelpers.PrepareConstrainedRegions();  

        try 
        {  
            bstr1 = Marshal.SecureStringToBSTR(s1);  
            bstr2 = Marshal.SecureStringToBSTR(s2);  

            unsafe 
            {  
                for (Char* ptr1 = (Char*)bstr1.ToPointer(), ptr2 = (Char*)bstr2.ToPointer();  
                    *ptr1 != 0 && *ptr2 != 0;  
                     ++ptr1, ++ptr2)  
                {  
                    if (*ptr1 != *ptr2)  
                    {  
                        return false;  
                    }  
                }  
            }  

            return true;  
        }  
        finally 
        {  
            if (bstr1 != IntPtr.Zero)  
            {  
                Marshal.ZeroFreeBSTR(bstr1);  
            }  

            if (bstr2 != IntPtr.Zero)  
            {  
                Marshal.ZeroFreeBSTR(bstr2);  
            }  
        }  
    }

    static void Main()
    {
        Program p = new Program();
        SecureString s1 = new SecureString();
        s1.AppendChar('a');
        s1.AppendChar('b');
        s1.AppendChar('c');
        s1.MakeReadOnly();

        SecureString s2 = new SecureString();
        s2.AppendChar('a');
        s2.AppendChar('b');
        s2.AppendChar('c');
        s2.MakeReadOnly();

        Console.WriteLine(p.SecureStringEqual(s1, s2));
    }
}