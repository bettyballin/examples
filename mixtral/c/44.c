sharp
using System;
using System.Security.Cryptography;
using System.Runtime.InteropServices;

public class X509Importer
{
    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern IntPtr CryptAcquireContextW(ref IntPtr hCryptProv, string pszContainer, string pszProvider, int dwProvType, int dwFlags);

    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern bool CryptImportPublicKeyInfo(IntPtr hCryptProv, int dwCertEncodingType, byte[] pbEncoded, int cbEncoded, ref IntPtr hPublicKey);

    public static IntPtr ImportX509PublicKey(byte[] x509Data)
    {
        IntPtr hCryptProv = IntPtr.Zero;
        IntPtr hPublicKey = IntPtr.Zero;

        if (CryptAcquireContextW(ref hCryptProv, null, null, 1, 0))
        {
            if (CryptImportPublicKeyInfo(hCryptProv, 1, x509Data, x509Data.Length, ref hPublicKey))
            {
                return hPublicKey;
            }
            else
            {
                IntPtr error = Marshal.GetLastWin32Error();
            }
        }
        else
        {
            IntPtr error = Marshal.GetLastWin32Error();
        }

        if (hCryptProv != IntPtr.Zero)
        {
            CryptReleaseContext(hCryptProv, 0);
        }

        return IntPtr.Zero;
    }

    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern bool CryptReleaseContext(IntPtr hCryptProv, int dwFlags);
}