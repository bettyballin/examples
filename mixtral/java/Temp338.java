import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;

public class UserAttributes {

    public Map<String, String> getUserAttributes(String username) {
        Hashtable<String, String> env = new Hashtable<>();

        // Set up environment for creating initial context
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        String ldapURL = "ldaps://your-ad-server:636";

        // Set up environment for creating initial context
        env.put(Context.PROVIDER_URL, ldapURL);

        // Authenticate as S. User and password
        env.put(Context.SECURITY_AUTHENTICATION, "simple");

        String adminName = "CN=Administrator,DC=your-domain";

        if (username != null) {
            adminName += ",OU=" + username;
        }

        // Set up environment for creating initial context
        env.put(Context.SECURITY_PRINCIPAL, adminName);

        String password = "your-password";

        // Set up environment for creating initial context
        env.put(Context.SECURITY_CREDENTIALS, password);

        Map<String, String> userAttributes = new HashMap<>();

        try {
            DirContext ctx = new InitialDirContext(env);

            SearchControls constraints = new SearchControls();

            String[] attrIDs = {"employeeNumber", "telephoneNumber"};
            constraints.setReturningAttributes(attrIDs);
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // Search for objects using filter
            NamingEnumeration<SearchResult> answer = ctx.search("DC=your-domain,DC=com",
                    "(sAMAccountName=" + username + ")", constraints);

            if (answer.hasMore()) {
                SearchResult result = answer.next();
                Attributes attrs = result.getAttributes();

                for (String attrID : attrIDs) {
                    Attribute attr = attrs.get(attrID);
                    if (attr != null) {
                        userAttributes.put(attrID, (String) attr.get());
                    }
                }
            }

            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return userAttributes;
    }

    public static void main(String[] args) {
        UserAttributes ua = new UserAttributes();
        Map<String, String> attributes = ua.getUserAttributes("someUsername");

        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}