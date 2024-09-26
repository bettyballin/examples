csharp
using System;
using System.DirectoryServices.AccountManagement;

class Program
{
    static string[] groupName = new string[] { "Group1", "Group2", "Group3" };
    static bool[] IsMember = new bool[3];

    static void Main(string[] args)
    {
        CheckGroupMembership();

        for (int i = 0; i < 3; i++)
        {
            Console.WriteLine($"Is member of {groupName[i]}: {IsMember[i]}");
        }
    }

    public static string GetUserName()
    {
        return Environment.UserName;
    }

    public static void CheckGroupMembership()
    {
        // set up domain context
        PrincipalContext ctx = new PrincipalContext(ContextType.Domain, "XXX");

        // find a user
        UserPrincipal user = UserPrincipal.FindByIdentity(ctx, GetUserName());

        for (int i = 0; i < 3; i++)
        {
            // find the group in question
            GroupPrincipal group = GroupPrincipal.FindByIdentity(ctx, groupName[i]);

            if (user != null)
            {
                // check if user is member of that group
                if (user.IsMemberOf(group))
                { 
                    IsMember[i] = true;  
                }
                else
                {
                    IsMember[i] = false;
                }
            }
        }
    }
}