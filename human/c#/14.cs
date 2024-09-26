csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] plaintext = Encoding.ASCII.GetBytes(
            "The quick brown fox jumps over the lazy dog");
    }
}