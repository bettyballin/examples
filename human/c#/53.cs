csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        bool sourceFound = false;
        try
        {
            sourceFound = EventLog.SourceExists("MySource");
        }
        catch (SecurityException)
        {
            sourceFound = false;
        }
        Console.WriteLine("Source found: " + sourceFound);
    }
}