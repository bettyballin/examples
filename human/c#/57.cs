csharp
using System;
using System.IO;
using System.Security.AccessControl;

public class Program
{
    public static void Main(string[] args)
    {
        string destination = @"C:\Path\To\Folder";
        string templatePath = @"C:\Path\To\Template\Folder";

        DirectorySecurity templateSecurity = Directory.GetAccessControl(templatePath);
        UpdateSecurity(destination, templateSecurity);
    }

    public static void UpdateSecurity(string destination, DirectorySecurity templateSecurity)
    {
        DirectorySecurity dSecurity = Directory.GetAccessControl(destination);

        string sddl = templateSecurity.GetSecurityDescriptorSddlForm(AccessControlSections.Access);
        try
        {
            // TOTALLY REPLACE The existing access rights with the new ones.
            dSecurity.SetSecurityDescriptorSddlForm(sddl, AccessControlSections.Access);

            // Disable inheritance for this directory.
            dSecurity.SetAccessRuleProtection(true, true);

            // Apply these changes.
            Directory.SetAccessControl(destination, dSecurity);
        }
        catch (Exception ex)
        {
            // Note the error on the console... we can formally log it later.
            Console.WriteLine(destination + " : " + ex.Message);
        }

        // Do some other settings stuff here...
    }
}