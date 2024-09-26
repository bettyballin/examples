csharp
using System;
using System.Security.AccessControl;

class Program
{
    static void Main()
    {
        InheritanceFlags flags = InheritanceFlags.ContainerInherit | InheritanceFlags.ObjectInherit;
        Console.WriteLine(flags);
    }
}