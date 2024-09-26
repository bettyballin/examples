csharp
using System;
using System.Threading.Tasks;
using Firebase.Database;

public class Program
{
    public static async Task Main()
    {
        // Initialize Firebase Realtime Database
        var client = new FirebaseClient("https://your-database-url.firebaseio.com/");

        // Set reference and currentTrade variables
        var reference = client;
        var currentTrade = new { date = DateTime.Now.ToString("yyyy-MM-dd") };
        var userId = "your-user-id";

        // Your original code
        if (!(await reference.Child("trading").Child("trade|" + currentTrade.date).Child("buyerId")
            .SetValueAsync(userId)).IsCanceled)
        {
            Console.WriteLine("Value set successfully");
        }
        else
        {
            Console.WriteLine("Operation canceled");
        }
    }
}