csharp
using System;
using System.IO;

class Program
{
    static void Main()
    {
        var fileStream2 = new FileStream("example.txt", FileMode.Open, FileAccess.Read, FileShare.Read);
    }
}