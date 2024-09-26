csharp
using System;
using CryptSharp;

class Program
{
    static void Main()
    {
        string password = "password goes here";
        string hash = "hash goes here";
        bool matches = Crypter.CheckPassword(password, hash);
        Console.WriteLine(matches);
    }
}