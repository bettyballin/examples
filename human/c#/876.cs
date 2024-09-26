csharp
using System;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

public class Student
{
    public string Name { get; set; }
    public int Age { get; set; }
}

class Program
{
    static void Main()
    {
        string jsonString = "{\"Student\":{\"Name\":\"John\",\"Age\":20}}";
        var parsedObject = JObject.Parse(jsonString);
        var studentObject = parsedObject["Student"].ToString();
        var responseData = JsonConvert.DeserializeObject<Student>(studentObject);

        Console.WriteLine(responseData.Name);
        Console.WriteLine(responseData.Age);
    }
}