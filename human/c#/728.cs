csharp
using System;
using System.Configuration;
using System.Data.Entity;

public class TestContext : DbContext
{
    public TestContext(string connectionStringName) : base(connectionStringName)
    {
    }

    public DbSet<Contact> Contacts { get; set; }
}

public class Contact
{
    public int ContactID { get; set; }
}

public static class Encrypt
{
    public static string EncryptString(string plainText, string key)
    {
        // implement your own encryption logic here
        // for demonstration purposes, a simple XOR encryption is used
        var encrypted = new char[plainText.Length];
        for (int i = 0; i < plainText.Length; i++)
        {
            encrypted[i] = (char)(plainText[i] ^ key[i % key.Length]);
        }
        return new string(encrypted);
    }

    public static string DecryptString(string encryptedText, string key)
    {
        // implement your own decryption logic here
        // for demonstration purposes, a simple XOR decryption is used
        var decrypted = new char[encryptedText.Length];
        for (int i = 0; i < encryptedText.Length; i++)
        {
            decrypted[i] = (char)(encryptedText[i] ^ key[i % key.Length]);
        }
        return new string(decrypted);
    }
}

class Program
{
    static void Main(string[] args)
    {
        // here I am using first takes  a valid connectionstring  from encrypt it.
        // this is needed because I am showing it in console application idealy this step is independent of this 
        // this needs to be done by some build and deployment tool which wil copy this encrypted string to app.config 

        var encryptString = Encrypt.EncryptString("Data Source=yashssd;Initial Catalog=StackOverFlow1;Integrated Security=True", "myKey");

        // this encryped connecton string I will save to th app.config manauly but this can be auutomated with build/ deployment tools

        //var decrypt = Encrypt.DecryptString(encryptString, "myKey");

        var connectionString = ConfigurationManager.ConnectionStrings["EncryptedConnection"];
        connectionString.ConnectionString = Encrypt.DecryptString(encryptString, "myKey");

        using (var ctx = new TestContext("EncryptedConnection"))
        {

            // for testing to see al working 
            //this is important to read the entity first .
            var contact = ctx.Contacts.FirstOrDefault(x => x.ContactID == 1);

        }

        Console.ReadLine();
    }
}