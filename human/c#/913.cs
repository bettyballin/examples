csharp
using System;
using System.Runtime.InteropServices;

class Program
{
    [DllImport("credui.dll", CharSet = CharSet.Unicode)]
    static extern int CredUIPromptForWindowsCredentials(
        ref CREDUI_INFO creduiInfo,
        int dwError,
        ref Guid authPackage,
        IntPtr inAuthBuffer,
        uint inAuthBufferSize,
        out IntPtr outCredBuffer,
        out uint outCredBufferSize,
        ref bool save,
        int flags);

    [DllImport("credui.dll", CharSet = CharSet.Unicode)]
    static extern bool CredUnPackAuthenticationBuffer(
        int dwFlags,
        IntPtr pAuthBuffer,
        uint cbAuthBuffer,
        StringBuilder pszUserName,
        ref int pcchMaxUserName,
        StringBuilder pszDomainName,
        ref int pcchMaxDomainName,
        StringBuilder pszPassword,
        ref int pcchMaxPassword);

    [StructLayout(LayoutKind.Sequential, CharSet = CharSet.Unicode)]
    public struct CREDUI_INFO
    {
        public int cbSize;
        public IntPtr hwndParent;
        [MarshalAs(UnmanagedType.ByValTStr, SizeConst = 128)]
        public string pszMessageText;
        [MarshalAs(UnmanagedType.ByValTStr, SizeConst = 128)]
        public string pszCaptionText;
        public IntPtr hbmBanner;
    }

    static void Main()
    {
        var credui = new CREDUI_INFO
        {
            cbSize = Marshal.SizeOf(typeof(CREDUI_INFO)),
            hwndParent = IntPtr.Zero,
            pszMessageText = "Enter credentials",
            pszCaptionText = "Credentials",
            hbmBanner = IntPtr.Zero
        };

        var authPackage = new Guid("6f45d514-854a-4d8c-9c8c-ae5e8c504d44");
        var inAuthBuffer = IntPtr.Zero;
        var inAuthSize = 0u;
        var outCredBuffer = IntPtr.Zero;
        var outCredSize = 0u;
        var save = false;

        var result = CredUIPromptForWindowsCredentials(
            ref credui,
            0,
            ref authPackage,
            inAuthBuffer,
            inAuthSize,
            out outCredBuffer,
            out outCredSize,
            ref save,
            0x10);

        var usernameBuf = new StringBuilder(256);
        var domainBuf = new StringBuilder(256);
        var passwordBuf = new StringBuilder(256);
        var maxUserName = 256;
        var maxDomain = 256;
        var maxPassword = 256;

        var packAuthRes = CredUnPackAuthenticationBuffer(
            1,
            outCredBuffer,
            outCredSize,
            usernameBuf,
            ref maxUserName,
            domainBuf,
            ref maxDomain,
            passwordBuf,
            ref maxPassword);

        Console.WriteLine($"Result: {result}");
        Console.WriteLine($"packAuthRes: {packAuthRes}");
        Console.WriteLine($"Username: {usernameBuf}");
        Console.WriteLine($"Domain: {domainBuf}");
        Console.WriteLine($"Password: {passwordBuf}");
    }
}