csharp
using System;

public class SomeoneCheatedException : Exception { }

public class Program
{
    private double FakeOptimumPointWithAConvincingName 
    { 
        get 
        { 
            throw new SomeoneCheatedException(); 
        } 
    }

    public static void Main()
    {
        try
        {
            Program p = new Program();
            var x = p.FakeOptimumPointWithAConvincingName;
        }
        catch (SomeoneCheatedException ex)
        {
            Console.WriteLine(ex.GetType().Name);
        }
    }
}