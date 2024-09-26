csharp
using System;

class Program
{
    static void Main()
    {
        object EmptyKey = null; // Define EmptyKey
        object sm = new { Mode = null, FeedbackSize = null }; // Define sm
        object IV = null; // Define IV

        object[] Par = { EmptyKey, sm.GetType().GetProperty("Mode"), IV, sm.GetType().GetProperty("FeedbackSize"), 1 };

        foreach (var item in Par)
        {
            Console.WriteLine(item);
        }
    }
}