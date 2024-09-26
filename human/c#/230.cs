csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        // Hashing
        string message = "Hello, World!";
        SHA256 sha256 = SHA256.Create();
        byte[] bytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(message));
        StringBuilder builder = new StringBuilder();
        foreach (byte b in bytes)
        {
            builder.Append(b.ToString("x2"));
        }
        string hash = builder.ToString();

        Console.WriteLine("Message: " + message);
        Console.WriteLine("Hash: " + hash);

        // Verification
        string receivedMessage = "Hello, World!";
        byte[] receivedBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(receivedMessage));
        StringBuilder receivedBuilder = new StringBuilder();
        foreach (byte b in receivedBytes)
        {
            receivedBuilder.Append(b.ToString("x2"));
        }
        string receivedHash = receivedBuilder.ToString();

        Console.WriteLine("Received Message: " + receivedMessage);
        Console.WriteLine("Received Hash: " + receivedHash);

        if (hash == receivedHash)
        {
            Console.WriteLine("Message is authentic.");
        }
        else
        {
            Console.WriteLine("Message is not authentic.");
        }
    }
}