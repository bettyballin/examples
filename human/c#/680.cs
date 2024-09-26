csharp
using System;
using System.Diagnostics;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var log = new EventLog
        {
            Source = "Microsoft Windows security auditing.",
            Log = "Security"
        };
        var latestLogon =
            log.Entries.Cast<EventLogEntry>()
              .Where(entry => entry.InstanceId == 4624 || entry.InstanceId == 4672)
              .OrderByDescending(i => i.TimeWritten)
              .FirstOrDefault();

        Console.WriteLine(latestLogon != null 
            ? $"Latest Logon: {latestLogon.TimeWritten}" 
            : "No logon entries found.");
    }
}