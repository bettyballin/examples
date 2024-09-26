csharp
using System;
using System.IO;

class Program
{
    static void Main()
    {
        string path = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.CommonApplicationData), 
            @"Microsoft\Crypto\RSA\MachineKeys");
        Console.WriteLine(path);
    }
}