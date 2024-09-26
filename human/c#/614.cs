csharp
using System;
using System.Diagnostics;
using Windows.Security.Cryptography;

class Program
{
    static async void Main()
    {
        var buff = CryptographicBuffer.GenerateRandom(20);
        var before = buff.ToArray();
        await buff.ClearContentsAsync();
        var after = buff.ToArray();
        Debug.WriteLine("{0},{1},{2} - {3},{4},{5}", 
            before[0], before[1], before[2], after[0], after[1], after[2]);
    }
}