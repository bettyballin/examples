csharp
using System;
using System.Security.AccessControl;
using System.Security.Principal;

public enum SampleRightsEnum
{
    Read = 1,
    Write = 2,
    Delete = 4,
    Execute = 8
}

public class SampleSecurity : ObjectSecurity<SampleRightsEnum>
{
    public SampleSecurity(bool isContainer) : base(isContainer) { }
}

public class SampleAccessRule : AccessRule<SampleRightsEnum>
{
    public SampleAccessRule(IdentityReference identity, SampleRightsEnum rights, AccessControlType type) 
        : base(identity, rights, type) { }
}

class Program
{
    static void Main(string[] args)
    {
        byte[] securityDescriptor = new byte[] { /* your security descriptor bytes */ };
        SampleSecurity security = new SampleSecurity(false);
        security.SetSecurityDescriptorBinaryForm(securityDescriptor, AccessControlSections.All);
        AuthorizationRuleCollection coll = security.GetAccessRules(true, false, typeof(NTAccount));
        foreach (AuthorizationRule rule in coll)
        {
            SampleAccessRule accRule = rule as SampleAccessRule;
            if (accRule != null)
            {
                SampleRightsEnum rights = (SampleRightsEnum)accRule.AccessRights;
                Console.WriteLine("User or Group {0} having the permissions {1} with access type {2}", 
                    rule.IdentityReference.Value, rights.ToString(), accRule.AccessControlType.ToString());
            }
        }
    }
}