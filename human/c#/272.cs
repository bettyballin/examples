csharp
using System;

public class SomeService
{
    public void SomeServiceMethod()
    {
        this.CheckSecurity();
        // some method code
        Console.WriteLine("Some method code executed.");
    }

    private void CheckSecurity()
    {
        Console.WriteLine("Security checked.");
        // Add your security check logic here
    }
}

class Program
{
    static void Main()
    {
        var someService = new SomeService();
        someService.SomeServiceMethod();
    }
}