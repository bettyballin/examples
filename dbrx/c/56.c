This is C# code, not C code. Here is the corrected and executable code:

sharp
using System;
using System.Runtime.InteropServices;
using System.Text;

public class Program
{
    [DllImport("advapi32.dll", CharSet = CharSet.Auto, SetLastError = true)]
    public static extern bool LookupAccountName(
        string lpSystemName,
        string lpAccountName,
        IntPtr Sid,
        ref uint cbSid,
        StringBuilder ReferencedDomainName,
        ref uint cchReferencedDomainName,
        out SID_NAME_USE peUse);

    public enum SID_NAME_USE
    {
        SidTypeUser = 1,
        SidTypeGroup,
        SidTypeDomain,
        SidTypeAlias,
        SidTypeWellKnownGroup,
        SidTypeDeletedAccount,
        SidTypeInvalid,
        SidTypeUnknown,
        SidTypeComputer,
        SidTypeLabel,
        SidTypeLogonSession
    }

    public static string ConvertSidToStringSid(byte[] sidBytes)
    {
        StringBuilder sidString = new StringBuilder();
        for (int i = 0; i < sidBytes.Length; i++)
        {
            sidString.AppendFormat("{0:x2}", sidBytes[i]);
        }
        return sidString.ToString();
    }

    public static void Main()
    {
        uint sidSize = 0;
        StringBuilder domainName = new StringBuilder();
        uint domainSize = (uint)domainName.Capacity;
        SID_NAME_USE nameUse;

        if (!LookupAccountName(null, "username", IntPtr.Zero, ref sidSize, domainName, ref domainSize, out nameUse))
        {
            Console.WriteLine("Error: " + Marshal.GetLastWin32Error());
            return;
        }

        IntPtr sidPtr = Marshal.AllocHGlobal((int)sidSize);
        if (!LookupAccountName(null, "username", sidPtr, ref sidSize, domainName, ref domainSize, out nameUse))
        {
            Console.WriteLine("Error: " + Marshal.GetLastWin32Error());
            if (sidPtr != IntPtr.Zero)
                Marshal.FreeHGlobal(sidPtr);
            return;
        }

        byte[] sidBytes = new byte[sidSize];
        Marshal.Copy(sidPtr, sidBytes, 0, (int)sidSize);
        string sidString = ConvertSidToStringSid(sidBytes);

        Console.WriteLine("SID: " + sidString);
        Console.WriteLine("Domain Name: " + domainName.ToString());
        Console.WriteLine("Name Use: " + nameUse);

        if (sidPtr != IntPtr.Zero)
            Marshal.FreeHGlobal(sidPtr);
    }
}