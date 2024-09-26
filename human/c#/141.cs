csharp
using System;
using System.Linq;
using System.Text;

class Program
{
    static void Main()
    {
        string code = "Your Hex Code Here";
        var back = (new ASCIIEncoding()).GetString(Convert.FromBase64String(
            Enumerable.Range(0, code.Length / 2)
            .Select(i => code.Substring(i * 2, 2))
            .Select(x => (char)Convert.ToInt32(x, 16))
            .Aggregate(new StringBuilder(), (x, y) => x.Append(y))
            .ToString()));
        Console.WriteLine(back);
    }
}