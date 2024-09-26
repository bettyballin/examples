csharp
using System;
using System.Runtime.CompilerServices;

public class Program
{
    [MethodImpl(MethodImplOptions.AggressiveInlining)]
    public static bool IsUsageAllowed()
    {
        return true; // Replace with actual logic
    }

    public static void Main(string[] args)
    {
        if (!IsUsageAllowed()) //detour call
            return;

        // do something
        Console.WriteLine("Usage allowed");
    }
}