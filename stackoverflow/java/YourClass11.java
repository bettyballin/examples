import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.Attribute;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;

public class YourClass11 {
    private LdapTemplate ldapTemplate;
    // Assuming dn_string and newPassword are defined elsewhere in your code
    String dn_string;
    String newPassword;
    String passwordAttr;

    public void changePassword() {
        DistinguishedName dn = new DistinguishedName(dn_string);
        Attribute passwordAttribute = new BasicAttribute(passwordAttr, newPassword);
        ModificationItem[] modificationItems = new ModificationItem[1];
        modificationItems[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, passwordAttribute);
        ldapTemplate.modifyAttributes(dn, modificationItems);
    }

    public LdapTemplate getLdapTemplate() {
        return ldapTemplate;
    }
}