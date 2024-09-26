csharp
using System;

class Program
{
    static void Main()
    {
        try
        {
            // Simulate an exception
            throw new Exception("Something went wrong");
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex);
        }
    }
}