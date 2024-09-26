csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        try
        {
            // Your cryptographic code here
        }
        catch (CryptographicUnexpectedOperationException ex)
        {
            if (ex.Message.Contains("EffectiveKeySize must be the same as KeySize in this implementation"))
            {
                Console.WriteLine(ex.Message);
            }
            else
            {
                throw;
            }
        }
    }
}