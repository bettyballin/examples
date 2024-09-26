import org.apache.commons.text.StringEscapeUtils;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import java.util.Hashtable;

public class Temp382 {
    public static void main(String[] args) {
        // Example inputs
        String searchBase = "dc=example,dc=com";
        String searchMask = "(uid=john.doe)";
        
        // Initialize DirContext and SearchControls
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=example,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        DirContext ctx;
        try {
            ctx = new InitialDirContext(env);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SearchControls scontrols = new SearchControls();
        scontrols.setSearchScope(SearchControls.SUBTREE_SCOPE);

        String searchBaseEscaped = StringEscapeUtils.escapeLDAPSearchFilter(searchBase);
        String searchMaskEscaped = StringEscapeUtils.escapeLDAPSearchFilter(searchMask);

        NamingEnumeration answer = null;
        try {
            answer = ctx.search(searchBaseEscaped, searchMaskEscaped, scontrols);
            printSearchEnumeration(answer);
        } catch (Exception e) {
            e.printStackTrace(); // handle exceptions
        } finally {
            try {
                ctx.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // This is a placeholder method. You need to implement this method according to your needs.
    private static void printSearchEnumeration(NamingEnumeration answer) {
        try {
            while (answer.hasMore()) {
                System.out.println(answer.next());
            }
        } catch (Exception e) {
            e.printStackTrace(); // handle exceptions
        }
    }
}