csharp
using System;
using System.Collections.Generic;
using System.Text;
using System.Security.Principal;
using System.Security.Permissions;

namespace SSRS_Custom_Fuctions
{
    public class Class1
    {

        public static bool IsInGroup(string user, string group)
        {
            System.Security.Permissions.SecurityPermission sp = new System.Security.Permissions.SecurityPermission(System.Security.Permissions.PermissionState.Unrestricted);
            sp.Assert();

            using (var identity = new WindowsIdentity(user))
            {
                var principal = new WindowsPrincipal(identity);
                return principal.IsInRole(group);
            }
        }

        public static string MyTest()
        {
            return "Hello World";
        }

        public static void Main(string[] args)
        {
            Console.WriteLine(MyTest());
            Console.WriteLine(IsInGroup("YourDomain\\YourUsername", "YourGroup"));
            Console.ReadLine();
        }
    }
}