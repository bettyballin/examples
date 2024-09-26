csharp
using System;

class Program
{
    static void Main()
    {
        bool authenticationSucceeded = false; // Replace with your authentication logic

        if (authenticationSucceeded)
        {
            Console.WriteLine("Access granted. Welcome to the program!");
            // Your program's main logic goes here
        }
        else
        {
            Console.WriteLine("Authentication failed. Exiting program.");
            Environment.Exit(1);
        }
    }
}