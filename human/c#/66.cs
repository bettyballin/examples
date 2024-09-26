csharp
using System;
using System.Security.AccessControl;
using System.Security.Principal;

public class Program
{
    public static void Main(string[] args)
    {
        var sec = new SampleSecurity(false);
        var user = new NTAccount("Current User");
        sec.AddAccessRule(user, (int)SampleRightsEnum.sampleRead, AccessControlType.Allow);
        sec.AddAccessRule(user, (int)SampleRightsEnum.sampleWrite, AccessControlType.Deny);
        foreach (SampleAccessRule rule in sec.GetAccessRules(true, true, typeof(NTAccount)))
        {
            Console.WriteLine($"Identity: {rule.IdentityReference.Value}, AccessRights: {rule.AccessRights}, AccessControlType: {rule.AccessControlType}");
        }
        var ruleToRemove = new SampleAccessRule(user, (int)SampleRightsEnum.sampleRead, AccessControlType.Allow);
        sec.RemoveAccessRule(ruleToRemove);
        foreach (SampleAccessRule rule in sec.GetAccessRules(true, true, typeof(NTAccount)))
        {
            Console.WriteLine($"Identity: {rule.IdentityReference.Value}, AccessRights: {rule.AccessRights}, AccessControlType: {rule.AccessControlType}");
        }
    }
}

public class SampleSecurity : CommonObjectSecurity
{
    public SampleSecurity(bool isContainer)
        : base(isContainer)
    {
    }

    public override AccessRule AccessRuleFactory(IdentityReference identityReference, 
        int accessMask, bool isInherited, InheritanceFlags inheritanceFlags, 
        PropagationFlags propagationFlags, AccessControlType type)
    {
        return new SampleAccessRule(identityReference, accessMask, type);
    }

    public void AddAccessRule(IdentityReference identityReference, 
        int accessMask, AccessControlType type)
    {
        base.AddAccessRule(new SampleAccessRule(identityReference, accessMask, type));
    }

    public void RemoveAccessRule(SampleAccessRule rule)
    {
        base.RemoveAccessRule(rule);
    }

    public override Type AccessRuleType
    {
        get { return typeof(SampleAccessRule); }
    }

    public override AuditRule AuditRuleFactory(System.Security.Principal.IdentityReference identityReference, int accessMask, bool isInherited, InheritanceFlags inheritanceFlags, PropagationFlags propagationFlags, AuditFlags flags)
    {
        throw new NotImplementedException();
    }

    public override Type AuditRuleType
    {
        get { throw new NotImplementedException(); }
    }

    public override Type AccessRightType
    {
        get { return typeof(SampleRightsEnum); }
    }
}

public class SampleAccessRule : AccessRule
{
    public SampleAccessRule(IdentityReference identity, int accessMask, AccessControlType accessType)
        : base(identity, accessMask, false, InheritanceFlags.None, PropagationFlags.None, accessType)
    {
    }

    public int AccessRights { get { return AccessMask; } }
}

public enum SampleRightsEnum
{
    sampleRead = 0x001,
    sampleWrite = 0x002,
    sampleExecute = 0x004
}