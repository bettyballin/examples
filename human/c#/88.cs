csharp
using Microsoft.SharePoint;
using System;

class Program
{
    static void Main(string[] args)
    {
        SPSecurity.RunWithElevatedPrivileges(delegate() 
        {
            // Note: It's important that you create all new SPSite and SPWeb
            // objects in the elevated context in order to actually use elevated
            // privileges. Failure to do so will cause your code to execute
            // without elevated privileges.
            using(SPSite site = new SPSite(SPContext.Current.Site.ID))
            {
                using(SPWeb web = site.OpenWeb(SPContext.Current.Web.ID))
                {
                    // run code here that requires elevated privileges.
                    Console.WriteLine("Running with elevated privileges...");
                }
            }
        });
    }
}