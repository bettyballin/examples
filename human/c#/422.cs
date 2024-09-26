csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int len = 5;

        Random rnd = new Random();
        StringBuilder b = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
          b.Append(chars[rnd.Next(chars.Length)]);
        }
        string result = b.ToString();

        Console.WriteLine(result);
    }
}