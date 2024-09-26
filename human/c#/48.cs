csharp
using System;
using System.Collections.Generic;
using System.Security.Principal;

public class CustomRoleProvider : System.Web.Security.RoleProvider
{
    public override string[] GetRolesForUser(string username)
    {
        List<string> roles = new List<string>(base.GetRolesForUser(username));
        if (roles.Contains("Reporting") && roles.Contains("Archiving"))
        {
            roles.Add("ReportingAndArchiving");
        }
        return roles.ToArray();
    }
}