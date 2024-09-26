csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main(string[] args)
    {
        string fullFileName = @"C:\Path\To\Your\File.exe";
        var versionInfo = FileVersionInfo.GetVersionInfo(fullFileName);
        var fileVersion = versionInfo.FileVersion;
        Console.WriteLine(fileVersion);
    }
}