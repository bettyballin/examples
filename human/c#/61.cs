csharp
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

public class Person
{
    private List<Person> _children = new List<Person>();

    public IList<Person> Children 
    { 
        get
        {
            return _children.AsReadOnly();
        } 
    }

    public void AddChild(Person child)
    {
        _children.Add(child);
    }
}

class Program
{
    static void Main()
    {
        Person parent = new Person();
        parent.AddChild(new Person());
        parent.AddChild(new Person());

        foreach (var child in parent.Children)
        {
            Console.WriteLine(child);
        }
    }
}