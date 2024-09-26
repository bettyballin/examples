csharp
using System;
using System.Collections.Generic;
using System.IO;
using System.Reflection;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        List<byte> total = new List<byte>(File.ReadAllBytes(System.Reflection.Assembly.GetEntryAssembly().Location));
        byte[] totalByteArray = total.ToArray();
        int OwnSize = 115200;//Size of you exe file without checksum
        int Md5Length = BitConverter.ToInt32(totalByteArray, OwnSize + 4);
        string NormalFileNameString = Encoding.ASCII.GetString(totalByteArray, OwnSize, Md5Length);

        Console.WriteLine(NormalFileNameString);
    }
}