csharp
using System;

class Program
{
    static void Main()
    {
        Console.WriteLine(new Uri(@"http://stackoverflow.com").IsLoopback);
        Console.WriteLine(new Uri(@"http://localhost/").IsLoopback);
        Console.WriteLine(new Uri(@"c:\windows\").IsLoopback);
    }
}