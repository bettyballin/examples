csharp
using System;
using System.Collections.Generic;
using System.Reflection;

public static class OutputExtensions
{
    public static void Export<T>(this List<T> list)
    {
        // get properties of Model
        PropertyInfo[] properties = typeof(T).GetProperties();

        foreach (var property in properties)
        {
            if (property.CanRead)
                Console.Write(property.Name + "\t");
        }
        Console.WriteLine();

        foreach (var entity in list)
        {
            foreach (var property in properties)
            {
                if (property.CanRead)
                    Console.Write(property.GetValue(entity, null) + "\t");
            }
            Console.WriteLine();
        }
    }
}

class Program
{
    static void Main()
    {
        List<Person> people = new List<Person>
        {
            new Person { Name = "John", Age = 30 },
            new Person { Name = "Alice", Age = 25 }
        };

        people.Export();
    }
}

public class Person
{
    public string Name { get; set; }
    public int Age { get; set; }
}