csharp
using System;
using System.Text.RegularExpressions;

public static class StringExtensions
{
    public static string MySqlEscape(this string usString)
    {
        if (usString == null)
        {
            return null;
        }
        // SQL Encoding for MySQL Recommended here:
        // http://au.php.net/manual/en/function.mysql-real-escape-string.php
        // it escapes \r, \n, \x00, \x1a, baskslash, single quotes, and double quotes
        return Regex.Replace(usString, @"[\r\n\x00\x1a\\'""]", @"\$0");
    }
}

class Program
{
    static void Main()
    {
        string originalString = "Hello\r\nWorld\x00\x1a\\'\"";
        string escapedString = originalString.MySqlEscape();
        Console.WriteLine("Original String: " + originalString);
        Console.WriteLine("Escaped String: " + escapedString);
    }
}