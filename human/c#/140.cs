csharp
using System;
using System.Linq;
using System.Text;

class Program
{
    static void Main()
    {
        var inputString = "xxxxx";
        var code = Convert.ToBase64String((new ASCIIEncoding()).GetBytes(inputString)).ToCharArray().Select(x => String.Format("{0:X}", (int)x)).Aggregate(new StringBuilder(), (x, y) => x.Append(y)).ToString();
        Console.WriteLine(code);
    }
}