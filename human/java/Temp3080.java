import javax.naming.directory.*;
import javax.naming.*;
import java.util.Hashtable;

public class Temp3080 {
    private static String dn_string = "cn=example";
    private static String passwordAttr = "userPassword";
    private static String newPassword = "newPassword123";

    public static void main(String[] args) {
        try {
            DistinguishedName dn = new DistinguishedName(dn_string);
            Attribute passwordAttribute = new BasicAttribute(passwordAttr, newPassword);
            ModificationItem[] modificationItems = new ModificationItem[1];
            modificationItems[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, passwordAttribute);

            getLdapTemplate().modifyAttributes(dn, modificationItems);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private static DirContext getLdapTemplate() throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=example,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "secret");
        return new InitialDirContext(env);
    }
}