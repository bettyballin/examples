csharp
using System;
using System.DirectoryServices.AccountManagement;

class Program
{
    static void Main(string[] args)
    {
        using (var context = new PrincipalContext(ContextType.Domain))
        {
            using (var user = UserPrincipal.FindByIdentity(context, "username"))
            {
                if (user != null)
                {
                    var groups = user.GetAuthorizationGroups();
                    foreach (var group in groups)
                    {
                        Console.WriteLine(group.Name);
                    }
                }
                else
                {
                    Console.WriteLine("User not found");
                }
            }
        }
        Console.ReadLine();
    }
}