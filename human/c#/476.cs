csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        string ivString = "your_iv_string_here";
        byte[] iv = System.Text.Encoding.UTF8.GetBytes(ivString);
        Console.WriteLine(BitConverter.ToString(iv));
    }
}