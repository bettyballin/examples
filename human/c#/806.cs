csharp
using System;
using System.Runtime.InteropServices;

[Flags]
internal enum SIGNATURE_INFO_FLAGS
{
    // insert enum values here, e.g.
    WT_SIGINFO_IMAGE = 0x00000002,
    WT_SIGINFO_VS_FIXEDFILEINFO = 0x00000004,
    // ...
}

[StructLayout(LayoutKind.Sequential)]
internal struct SIGNATURE_INFO
{
    // insert struct members here, e.g.
    public int cbStruct;
    public int dwIndex;
    public IntPtr dwAttrType;
    // ...
}

internal class Program
{
    [DllImport("wintrust.dll", EntryPoint = "WTGetSignatureInfo", CallingConvention = CallingConvention.StdCall)]
    internal static extern int WTGetSignatureInfo([In] [MarshalAs(UnmanagedType.LPWStr)] string pszFile, [In] IntPtr hFile, SIGNATURE_INFO_FLAGS sigInfoFlags, ref SIGNATURE_INFO psiginfo, ref IntPtr ppCertContext, ref IntPtr phWVTStateData);

    static void Main(string[] args)
    {
        SIGNATURE_INFO sigInfo = new SIGNATURE_INFO();
        IntPtr ppCertContext = IntPtr.Zero;
        IntPtr phWVTStateData = IntPtr.Zero;
        int result = WTGetSignatureInfo("path_to_your_file.exe", IntPtr.Zero, SIGNATURE_INFO_FLAGS.WT_SIGINFO_IMAGE, ref sigInfo, ref ppCertContext, ref phWVTStateData);
        Console.WriteLine($"Result: {result}");
    }
}