csharp
using System;
using System.Runtime.InteropServices;

[StructLayout(LayoutKind.Sequential)]
public struct BCRYPT_ECCKEY_BLOB
{
    public byte[] X;
    public byte[] Y;
    public byte[] d;
}

class Program
{
    static void Main()
    {
        int cbKey = 32; // example key size
        BCRYPT_ECCKEY_BLOB blob = new BCRYPT_ECCKEY_BLOB
        {
            X = new byte[cbKey],
            Y = new byte[cbKey],
            d = new byte[cbKey]
        };
    }
}