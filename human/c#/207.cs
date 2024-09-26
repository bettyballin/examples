csharp
using System;
using System.Runtime.Intrinsics.X86;
using System.Security.Cryptography;

public class Crc32HardwareAlgorithm : HashAlgorithm
{
    private uint _crc;
    private bool _x64Available;

    public Crc32HardwareAlgorithm()
    {
        if (!Sse42.IsSupported)
        {
            throw new NotSupportedException("SSE4.2 is not supported");
        }

        _x64Available = Sse42.X64.IsSupported;

        this.HashSizeValue = 32;
        this.Reset();
    }

    protected override void HashCore(byte[] array, int ibStart, int cbSize)
    {
        if (_x64Available)
        {
            while (cbSize >= 8)
            {
                _crc = (uint)Sse42.X64.Crc32(_crc, BitConverter.ToUInt64(array, ibStart));
                ibStart += 8;
                cbSize -= 8;
            }
        }

        while (cbSize > 0)
        {
            _crc = Sse42.Crc32(_crc, array[ibStart]);
            ibStart++;
            cbSize--;
        }
    }

    protected override byte[] HashFinal()
    {
        uint outputCrcValue = ~_crc;

        return BitConverter.GetBytes(outputCrcValue);
    }

    public override void Initialize()
    {
        this.Reset();
    }

    private void Reset()
    {
        _crc = uint.MaxValue;
    }

    public static void Main(string[] args)
    {
        var crc32 = new Crc32HardwareAlgorithm();
        var bytes = System.Text.Encoding.UTF8.GetBytes("Hello, World!");
        var hash = crc32.ComputeHash(bytes);
        Console.WriteLine(BitConverter.ToUInt32(hash, 0));
    }
}