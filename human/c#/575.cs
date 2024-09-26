csharp
using System;
using System.Linq;
using Microsoft.EntityFrameworkCore;

public class AspNetUser
{
    public string Username { get; set; }
}

public class MyDbContext : DbContext
{
    public DbSet<AspNetUser> AspNetUsers { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseInMemoryDatabase(databaseName: "MyDb");
    }
}

class Program
{
    static void Main()
    {
        var db = new MyDbContext();
        db.AspNetUsers.Add(new AspNetUser { Username = "Bob" });
        db.SaveChanges();

        var result = db.AspNetUsers.Where(w => w.Username == "Bob").AsEnumerable();

        foreach (var user in result)
        {
            Console.WriteLine(user.Username);
        }
    }
}