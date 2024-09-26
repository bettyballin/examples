csharp
using MongoDB.Bson;
using MongoDB.Driver;

class Program
{
    static void Main(string[] args)
    {
        var client = new MongoClient("mongodb+srv://kay:myRealPassword@cluster0.mongodb.net/test?w=majority");
        var db = client.GetDatabase("test");
    }
}