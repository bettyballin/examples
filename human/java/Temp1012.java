import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import java.util.Hashtable;

public class Temp1012 {
    public static void main(String[] args) {
        Hashtable<String, String> properties = new Hashtable<>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "LDAP://yourldap:389");
        String ldapqueryuser = "yourLdapQueryUser"; // Replace with actual user
        String ldapqueryuserpassword = "yourLdapQueryUserPassword"; // Replace with actual password
        properties.put(Context.SECURITY_PRINCIPAL, ldapqueryuser + "@yourldap");
        properties.put(Context.SECURITY_CREDENTIALS, ldapqueryuserpassword);

        DirContext dirContext = null;
        try {
            // initializing active directory LDAP connection
            dirContext = new InitialDirContext(properties);

            String name = "yourSearchBase"; // Replace with actual search base
            String filter = "(objectClass=*)"; // Replace with actual filter
            SearchControls cons = new SearchControls();
            cons.setSearchScope(SearchControls.SUBTREE_SCOPE);

            dirContext.search(name, filter, cons);
            System.out.println("LDAP search executed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dirContext != null) {
                try {
                    dirContext.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}