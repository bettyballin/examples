csharp
using System;

class PersonModel
{
    public string Name { get; set; }

    public Person ToPerson()
    {
        return new Person { Name = Name };
    }
}

class Person
{
    public bool IsAdmin { get; set; }
    public string Name { get; set; }
}

class Program
{
    static void Main(string[] args)
    {
        PersonModel model = new PersonModel { Name = "John" };
        Person person = model.ToPerson();
        Console.WriteLine(person.Name);
    }
}