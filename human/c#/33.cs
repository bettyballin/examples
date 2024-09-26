csharp
using System;
using System.Security.Permissions;
using System.Security.Principal;

class Program
{
    public enum Roles
    {
        Admin,
        User
    }

    public class MyClass
    {
        [PrincipalPermission(SecurityAction.Demand, Role = "Admin")]
        public void Foo()
        {
            Console.WriteLine("Foo executed successfully.");
        }
    }

    static void Main(string[] args)
    {
        AppDomain.CurrentDomain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal);

        MyClass obj = new MyClass();

        try
        {
            obj.Foo();
        }
        catch (SecurityException ex)
        {
            Console.WriteLine("Security exception: " + ex.Message);
        }

        Console.ReadLine();
    }
}