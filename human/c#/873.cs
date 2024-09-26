csharp
using System;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        string[] cardNumbers = new string[] 
        {
            "1234567890123456",
            "1234-56-7890-1234",
            "1234 56 7890 1234"
        };

        string pattern1 = @"(?<=\d{4}\d{2})\d{2}\d{4}(?=\d{4})";
        string pattern2 = @"(?<=\d{4}( |-)\d{2})\d{2}\1\d{4}(?=\1\d{4})";

        foreach (string cardNumber in cardNumbers)
        {
            Match match1 = Regex.Match(cardNumber, pattern1);
            Match match2 = Regex.Match(cardNumber, pattern2);

            Console.WriteLine($"Card Number: {cardNumber}");
            Console.WriteLine($"Match with pattern 1: {match1.Success}");
            Console.WriteLine($"Match with pattern 2: {match2.Success}");
            Console.WriteLine();
        }
    }
}