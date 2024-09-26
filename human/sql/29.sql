csharp
using System.Text.RegularExpressions;

public static class StringExtensions
{
    public static string MySqlEscape(this string usString)
    {
        if (usString == null)
        {
            return null;
        }
        return Regex.Replace(usString, @"[\r\n\x00\x1a\\'""]", @"\$0");
    }
}

class Program
{
    static void Main()
    {
        string originalString = "Hello \r\n World!";
        string escapedString = originalString.MySqlEscape();
        System.Console.WriteLine(escapedString);
    }
}