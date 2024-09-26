csharp
using System;
using System.Security.Principal;

class Program
{
    static void Main()
    {
        WindowsIdentity windowsIdentity = WindowsIdentity.GetCurrent();
        Console.WriteLine(windowsIdentity.Name);
    }
}