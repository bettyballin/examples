csharp
using System;
using System.DirectoryServices.AccountManagement;
using System.Linq;
using System.Management;

public class WMI
{
    public static ManagementObjectCollection Query(string query)
    {
        var searcher = new ManagementObjectSearcher(query);
        return searcher.Get();
    }
}

class Program
{
    public static dynamic[] Users => WMI.Query("SELECT * FROM Win32_UserAccount WHERE Disabled = 0").Cast<ManagementObject>().Select(d => {
        using (var machineContext = new PrincipalContext(ContextType.Machine))
        using (Principal principal = Principal.FindByIdentity(machineContext, d["SID"].ToString()))
        {
            dynamic result = new ExpandoObject();
            result.SID = d["SID"];
            result.IsAdmin = principal.GetGroups().Any(i => i.Sid.IsWellKnown(System.Security.Principal.WellKnownSidType.BuiltinAdministratorsSid));
            return result;
        }
    }).ToArray();

    static void Main(string[] args)
    {
        var users = Users;
        foreach (var user in users)
        {
            Console.WriteLine($"SID: {user.SID}, IsAdmin: {user.IsAdmin}");
        }
    }
}