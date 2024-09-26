csharp
using System;

class Program
{
    static void Main()
    {
        Uri uri = new Uri("http://foo.com/page.html?query");
        string query = uri.Query;
        Console.WriteLine(query);
    }
}