csharp
using System;
using System.IO;

class Program
{
    static void Main()
    {
        using (FileStream fsInput = new FileStream("input.bin", FileMode.Open))
        {
            byte[] buffer = new byte[8];
            fsInput.Read(buffer, 0, 8);
            long fileLength = BitConverter.ToInt64(buffer, 0);
            Console.WriteLine(fileLength);
        }
    }
}