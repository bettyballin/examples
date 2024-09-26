import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapLogin {
    public static void main(String[] args) {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=domain,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        try {
            DirContext ctx = new InitialDirContext(env);
            System.out.println("Connected to LDAP server");

            String base = "ou=people,dc=domain,dc=com";
            String filter = "(cn=someUser)";

            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search(base, filter, sc);
            if (results.hasMore()) {
                SearchResult sr = results.next();
                System.out.println("User found: " + sr.getName());
            } else {
                System.out.println("User not found.");
            }
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}