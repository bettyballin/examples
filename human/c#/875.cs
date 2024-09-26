csharp
using System;
using Newtonsoft.Json;

public class Student
{
    public string Name { get; set; }
    public int Age { get; set; }
}

class Program
{
    static void Main()
    {
        string json = "{\"Name\":\"John\",\"Age\":30}";
        Student jsonData = JsonConvert.DeserializeObject<Student>(json);
        Console.WriteLine(jsonData.Name);
        Console.WriteLine(jsonData.Age);
    }
}