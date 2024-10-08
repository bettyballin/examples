csharp
using System;
using System.IO;
using System.Security.Cryptography;

class Test
{
    static void Main(string[] args)
    {
        try
        {
            byte[] plaintext = File.ReadAllBytes("b.txt");
            using (MD5 md5 = MD5.Create())
            {
                byte[] md5Hash = md5.ComputeHash(plaintext);
                Console.WriteLine(BitConverter.ToString(md5Hash));
            }

            using (SHA1 sha1 = SHA1.Create())
            {
                byte[] sha1Hash = sha1.ComputeHash(plaintext);
                Console.WriteLine(BitConverter.ToString(sha1Hash));
            }
        }
        catch (FileNotFoundException)
        {
            Console.WriteLine("The file 'b.txt' was not found.");
        }
        catch (Exception ex)
        {
            Console.WriteLine("An error occurred: " + ex.Message);
        }

        Console.ReadKey();
    }
}