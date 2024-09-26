csharp
using System;
using System.Linq;

class Program
{
    static void Main()
    {
        Random rnd = new Random();
        int s = 10; // length of the OTP
        var otp = string.Concat(Enumerable.Range(0, s)
                                  .Select(i => (char)(rnd.Next(26) + 'A')));
        Console.WriteLine(otp);
    }
}