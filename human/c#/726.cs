csharp
using System;
using System.Data.Entity;
using System.Configuration;

public class TestContext : DbContext
{
    public TestContext(string connectionName)
    {
        var conn = ConfigurationManager.ConnectionStrings["EncryptedConnection"].ConnectionString;
        this.Database.Connection.ConnectionString = Encrypt.DecryptString(conn, "myKey");
    }

    public virtual DbSet<Contact> Contacts { get; set; }
}

public class Contact
{
    public int Id { get; set; }
    public string Name { get; set; }
}

public static class Encrypt
{
    public static string DecryptString(string encryptedString, string key)
    {
        // Your decryption logic here
        throw new NotImplementedException();
    }
}

class Program
{
    static void Main(string[] args)
    {
        using (var context = new TestContext("connectionName"))
        {
            var contacts = context.Contacts.ToList();
            foreach (var contact in contacts)
            {
                Console.WriteLine(contact.Name);
            }
        }
    }
}