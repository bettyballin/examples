csharp
using System;

class Person
{
    public bool IsAdmin { get; set; }
    public string Name { get; set; }
}

class Program
{
    static void Main()
    {
        Person person = new Person { IsAdmin = true, Name = "John Doe" };
        Console.WriteLine($"Name: {person.Name}, Is Admin: {person.IsAdmin}");
    }
}