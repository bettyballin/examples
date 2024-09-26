csharp
using System;
using System.IO;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        string input = @"2020-01-09 15:50:05,396 INFO  item-0
2020-01-09 15:50:05,419 INFO  item-1
2020-01-09 15:50:05,430 INFO  item-2
2020-01-09 15:50:05,441 INFO  item-3
2020-01-09 15:50:05,452 INFO  item-4
2020-01-09 15:50:05,463 INFO  item-5
2020-01-09 15:50:05,474 INFO  item-6
2020-01-09 15:50:05,485 INFO  item-7
2020-01-09 15:50:05,496 INFO  item-8
2020-01-09 15:50:05,507 INFO  item-9
2020-01-09 15:50:05,518 INFO  item-10
2020-01-09 15:50:07,403 INFO  item-183
2020-01-09 15:50:07,425 INFO  item-185
2020-01-09 15:50:07,436 INFO  item-186
2020-01-09 15:50:07,447 INFO  item-187
2020-01-09 15:50:07,458 INFO  item-188
2020-01-09 15:50:07,469 INFO  item-189
2020-01-09 15:50:07,480 INFO  item-190
2020-01-09 15:50:07,491 INFO  item-191
2020-01-09 15:50:07,502 INFO  item-192
2020-01-09 15:50:07,513 INFO  item-193
2020-01-09 15:50:07,538 INFO  item-194
2020-01-09 15:50:09,406 INFO  item-366
2020-01-09 15:50:09,427 INFO  item-368
2020-01-09 15:50:09,438 INFO  item-369
2020-01-09 15:50:09,449 INFO  item-370
2020-01-09 15:50:09,460 INFO  item-371
2020-01-09 15:50:09,472 INFO  item-372";

        string[] lines = input.Split('\n');
        foreach (string line in lines)
        {
            string pattern = @"(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2},\d{3}) (\w+)\s+(.*)";
            Match match = Regex.Match(line, pattern);
            if (match.Success)
            {
                Console.WriteLine($"datetime: {match.Groups[1].Value}, log_level: {match.Groups[2].Value}, message: {match.Groups[3].Value}");
            }
        }
    }
}