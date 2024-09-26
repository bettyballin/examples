csharp
using System;
using System.Linq;
using System.Text;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        byte[] b = new byte[4];
        var r = new Random();
        while (true) {
            r.NextBytes(b);
            var s = Encoding.Unicode.GetString(b);
            var expected = b;
            var actual = Encoding.Unicode.GetBytes(s);
            if (!actual.SequenceEqual(expected)) {
                Console.WriteLine(
                    $"Fail: expected {BitConverter.ToString(expected)}, " +
                    $"got {BitConverter.ToString(actual)}"
                );
                break;
            }
        }
    }
}