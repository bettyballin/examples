csharp
using System;
using System.IO;
using System.Threading;

class Program
{
    public static void Main()
    {
        var fileSystemWatcher = new FileSystemWatcher("C:\\Temp", "*.*");
        fileSystemWatcher.NotifyFilter = NotifyFilters.Security;
        fileSystemWatcher.Changed += fileSystemWatcher_Changed;
        fileSystemWatcher.EnableRaisingEvents = true;
        Thread.Sleep(Timeout.Infinite);
    }

    private static void fileSystemWatcher_Changed(object sender, FileSystemEventArgs e)
    {
        Console.WriteLine($"File {e.FullPath} changed");
    }
}