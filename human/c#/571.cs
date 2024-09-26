csharp
using System;
using System.IO;

class Program
{
    private static byte[] ReadFully(Stream stream, int length)
    {
        int offset = 0;
        byte[] buffer = new byte[length];
        while (offset < length)
        {
            int bytesRead = stream.Read(buffer, offset, length - offset);
            if (bytesRead == 0)
                throw new EndOfStreamException();
            offset += bytesRead;
        }
        return buffer;
    }

    static void Main(string[] args)
    {
        using (FileStream fileStream = new FileStream("test.txt", FileMode.Open))
        {
            byte[] data = ReadFully(fileStream, (int)fileStream.Length);
            Console.WriteLine(BitConverter.ToString(data));
        }
    }
}