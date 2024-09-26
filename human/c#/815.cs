csharp
using System;

public class Program
{
    public static void Main()
    {
        ModulusCalculator calculator = new ModulusCalculator();
        calculator.CalculateModulusBytes();
    }
}

public class Parameters
{
    public byte[] Modulus { get; set; }
}

public class ModulusCalculator
{
    public Parameters parameters { get; set; }

    public ModulusCalculator()
    {
        parameters = new Parameters();
        parameters.Modulus = new byte[] { 0x80 };
    }

    public void CalculateModulusBytes()
    {
        int modulusBytes = parameters.Modulus.Length;

        if (parameters.Modulus[0] >= 0x80)
            modulusBytes++;

        Console.WriteLine(modulusBytes);
    }
}