csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        var key = "your_key_here";
        var message = "your_message_here";

        if (Encoding.UTF8.GetBytes(message).Length < 64)
        {
            throw new Exception("Invalid message length.");
        }

        var mac = Encoding.UTF8.GetString(Encoding.UTF8.GetBytes(message), 0, 64);
        var data = Encoding.UTF8.GetString(Encoding.UTF8.GetBytes(message), 64, Encoding.UTF8.GetBytes(message).Length - 64);

        using (var hmacsha256 = new HMACSHA256(Encoding.UTF8.GetBytes(key)))
        {
            var recalc = BitConverter.ToString(hmacsha256.ComputeHash(Encoding.UTF8.GetBytes(data))).Replace("-", "").ToLower();

            if (recalc != BitConverter.ToString(Encoding.UTF8.GetBytes(mac)).Replace("-", "").ToLower())
            {
                throw new Exception("Invalid MAC.");
            }
        }

        Console.WriteLine("Data is legitimate.");
    }
}