csharp
using System;
using System.Runtime.InteropServices;

class Program
{
    static void Main()
    {
        SecureString password = new SecureString();

        Console.Write("Enter password: ");
        foreach (char c in Console.ReadLine())
        {
            password.AppendChar(c);
        }
        password.MakeReadOnly();

        IntPtr unmanagedBytes = Marshal.SecureStringToGlobalAllocUnicode(password);
        byte[] bValue = null;
        try
        {
            byte* byteArray = (byte*)unmanagedBytes.ToPointer();

            // Find the end of the string
            byte* pEnd = byteArray;
            char c = '\0';
            do
            {
                byte b1 = *pEnd++;
                byte b2 = *pEnd++;
                c = (char)(b1 << 8);
                c += (char)b2;
            } while (c != '\0');

            // Length is effectively the difference here (note we're 2 past end) 
            int length = (int)((pEnd - byteArray) - 2);
            bValue = new byte[length];
            for (int i = 0; i < length; ++i)
            {
                // Work with data in byte array as necessary, via pointers, here
                bValue[i] = *(byteArray + i);
            }
        }
        finally
        {
            // This will completely remove the data from memory
            Marshal.ZeroFreeGlobalAllocUnicode(unmanagedBytes);
        }

        foreach (var item in bValue)
        {
            Console.Write(item + " ");
        }
    }
}