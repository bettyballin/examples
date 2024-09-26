csharp
using System;

class Client
{
    public static void getTransactions(bool flag, string username, string password, string period, int year, string methodSignature, string database)
    {
        Console.WriteLine($"flag: {flag}, username: {username}, password: {password}, period: {period}, year: {year}, methodSignature: {methodSignature}, database: {database}");
    }
}

class Program
{
    static void Main()
    {
        string username = "your_username";
        string password = "your_password";
        string period = "your_period";
        int year = 2022;
        string methodSignature = "your_methodSignature";
        string database = "your_database";

        Client.getTransactions(true, username, password, period, year, methodSignature, database);
    }
}