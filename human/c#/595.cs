csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] decrypted = Encoding.UTF8.GetBytes("Hello, World!");
        Console.WriteLine("Output: " + Convert.ToBase64String(decrypted));
    }
}