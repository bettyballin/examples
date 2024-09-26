csharp
using System;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        string pattern = @"(?<=\d{4}\d{2})\d{2}\d{4}(?=\d{4})|(?<=\d{4}( |-)\d{2})\d{2}\1\d{4}(?=\1\d{4})";
        string input = "1234567890123456 1234-56-7890-1234";

        MatchCollection matches = Regex.Matches(input, pattern);

        foreach (Match match in matches)
        {
            Console.WriteLine(match.Value);
        }
    }
}