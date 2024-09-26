csharp
using System;
using System.IO;
using Newtonsoft.Json;
using Newtonsoft.Json.Bson;

public class SerializationHelper
{
    public object Deserialize<T>(Stream serializationStream)
    {
        JsonSerializer serializer = new JsonSerializer();
        T instance;

        BsonReader reader = new BsonReader(serializationStream);
        instance = serializer.Deserialize<T>(reader);

        return instance;
    }

    public void Serialize(Stream serializationStream, object graph)
    {
        JsonSerializer serializer = new JsonSerializer();

        using (BsonWriter writer = new BsonWriter(serializationStream))
        {
            serializer.Serialize(writer, graph);
        }
    }
}

class Program
{
    static void Main(string[] args)
    {
        SerializationHelper helper = new SerializationHelper();

        // Create a test object
        TestClass testObject = new TestClass { Foo = "bar" };

        // Serialize the object
        using (MemoryStream stream = new MemoryStream())
        {
            helper.Serialize(stream, testObject);

            // Deserialize the object
            stream.Position = 0;
            TestClass deserializedObject = (TestClass)helper.Deserialize<TestClass>(stream);

            Console.WriteLine(deserializedObject.Foo); // Outputs: bar
        }
    }
}

public class TestClass
{
    public string Foo { get; set; }
}