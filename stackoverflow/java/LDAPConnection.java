import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import java.util.Properties;

public class LDAPConnection {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "LDAP://yourldap:389");
        properties.put(Context.SECURITY_PRINCIPAL, "ldapqueryuser@yourldap");
        properties.put(Context.SECURITY_CREDENTIALS, "ldapqueryuserpassword");

        DirContext dirContext = null;
        try {
            // initializing active directory LDAP connection
            dirContext = new InitialDirContext(properties);
            SearchControls cons = new SearchControls();
            // Set up search filter and base name
            String filter = "(objectClass=*)";
            String name = "cn=users,dc=yourldap,dc=com";
            // Perform the search
            dirContext.search(name, filter, cons);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dirContext != null) {
                    dirContext.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}