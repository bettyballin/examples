csharp
using System;

[StructLayout(LayoutKind.Sequential)]
public struct BCRYPT_ECCKEY_BLOB
{
    public byte[] X;
    public byte[] Y;

    public BCRYPT_ECCKEY_BLOB(int cbKey)
    {
        X = new byte[cbKey];
        Y = new byte[cbKey];
    }
}