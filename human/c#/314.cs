csharp
using System;
using System.Security.Principal;
using System.Security.AccessControl;

class Program
{
    static void Main()
    {
        var identity = WindowsIdentity.GetCurrent();
        var administrativeUsers = new WindowsPrincipal(identity).IsInRole(new SecurityIdentifier("S-1-5-32-544"));

        Console.WriteLine(IsAdministrativeUser(identity, administrativeUsers));
    }

    static bool IsAdministrativeUser(WindowsIdentity me, bool administrativeUsers)
    {
        var mySid = me.User.Value;

        var admins = new NTAccount("Administrators").Translate(typeof(SecurityIdentifier)) as SecurityIdentifier;

        var adminGroup = new PrincipalSID(admins.Value);

        var users = WindowsIdentity.GetCurrent().Groups;

        foreach (var user in users)
        {
            if (user.Value == admins.Value)
            {
                if (me.User.Value == user.Value) return true;
            }
        }
        return false;
    }
}

public class PrincipalSID
{
    public string Value { get; set; }

    public PrincipalSID(string value)
    {
        Value = value;
    }
}