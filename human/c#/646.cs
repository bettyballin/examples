csharp
using System;
using System.ComponentModel.DataAnnotations.Schema;

public class MyClass
{
    // this property will be persisted in the database, but can't be modified from outside
    public string SSN { get; private set; }

    // the attribute will make sure this doesn't get mapped to the db
    // this property uses the other property as a backing field with proper conversions
    [NotMapped]
    public string SSNDecrypted
    {
        get 
        {
            return MyEncryptionClass.Decrypt(this.SSN);
        }
        set
        {
            this.SSN =  MyEncryptionClass.Encrypt(value);
        }
    }
}

public static class MyEncryptionClass
{
    public static string Encrypt(string value)
    {
        // implement encryption logic here
        return Convert.ToBase64String(System.Text.Encoding.UTF8.GetBytes(value));
    }

    public static string Decrypt(string value)
    {
        // implement decryption logic here
        return System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(value));
    }
}

class Program
{
    static void Main()
    {
        var obj = new MyClass();
        obj.SSNDecrypted = "123-45-6789";
        Console.WriteLine(obj.SSNDecrypted);
    }
}