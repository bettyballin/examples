csharp
using System;

class Program
{
    static void Main()
    {
        var method = typeof(string[,]).GetMethod("GetValue", 
                                             new Type[] { typeof(int), typeof(int) });
        var func = Delegate.CreateDelegate(typeof(Func<int, int, object>), 
                                             new string[4, 5], method);

        Console.WriteLine(func.DynamicInvoke(1, 2));
    }
}