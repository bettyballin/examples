csharp
using System;
using System.DirectoryServices.AccountManagement;
using System.Linq;

class Program
{
    static void Main()
    {
        PrincipalSearchResult<Principal> groups = UserPrincipal.Current.GetGroups();
        IEnumerable<string> groupNames = groups.Select(x => x.SamAccountName);
        foreach (var groupName in groupNames)
        {
            Console.WriteLine(groupName);
        }
    }
}