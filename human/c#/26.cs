csharp
using System;
using System.Reflection;

class Program
{
    static void Main()
    {
        Type t = typeof(Program);
        MemberInfo[] members = t.GetMembers(BindingFlags.NonPublic | 
                                            BindingFlags.Static |
                                            BindingFlags.Instance);

        foreach (var member in members)
        {
            Console.WriteLine(member.Name);
        }
    }
}