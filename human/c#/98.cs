csharp
using System;
using System.Runtime.InteropServices;
using System.Text;

public class Program
{
    [DllImport("ole32.dll")]
    static extern int CoQueryClientBlanket(out IntPtr pAuthnSvc, out IntPtr pAuthzSvc,
        [MarshalAs(UnmanagedType.LPWStr)] out StringBuilder pServerPrincName, out IntPtr
        pAuthnLevel, out IntPtr pImpLevel, out IntPtr pPrivs, out IntPtr pCapabilities);

    public static string CallingUser
    {
        get
        {
            IntPtr pAthnSvc = new IntPtr();
            IntPtr pAthzSvc = new IntPtr();
            StringBuilder pServerPrincName = new StringBuilder();
            IntPtr pAuthnLevel = new IntPtr();
            IntPtr pImpLevel = new IntPtr();
            IntPtr pPrivs = new IntPtr();
            IntPtr pCaps = new IntPtr(4);
            string sCallingUser = string.Empty;

            try
            {
                CoQueryClientBlanket(out pAthnSvc,
                    out pAthzSvc,
                    out pServerPrincName,
                    out pAuthnLevel,
                    out pImpLevel,
                    out pPrivs,
                    out pCaps);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                sCallingUser = Marshal.PtrToStringAuto(pPrivs);
            }

            return sCallingUser;
        }
    }

    public static void Main()
    {
        Console.WriteLine(CallingUser);
    }
}