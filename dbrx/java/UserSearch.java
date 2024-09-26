import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import java.util.Hashtable;

public class UserSearch implements LdapUserSearch {
    private String searchBase;
    private String searchFilter;

    public UserSearch() {
        this.searchBase = System.getProperty("ldap.search.base", "OU=AA,DC=UD,DC=BB,DC=local");
        this.searchFilter = System.getProperty("ldap.search.filter", "(sAMAccountName={0})");
    }

    @Override
    public DirContextOperations searchForUser(String username) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your-ldap-server:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "your-ldap-user");
        env.put(Context.SECURITY_CREDENTIALS, "your-ldap-password");

        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String filter = searchFilter.replace("{0}", username);

            NamingEnumeration<SearchResult> results = ctx.search(searchBase, filter, searchControls);
            if (results.hasMore()) {
                SearchResult result = results.next();
                return new DirContextOperations(result.getAttributes());
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface LdapUserSearch {
        DirContextOperations searchForUser(String username);
    }

    public static class DirContextOperations {
        private Attributes attributes;

        public DirContextOperations(Attributes attributes) {
            this.attributes = attributes;
        }

        public Attributes getAttributes() {
            return attributes;
        }
    }

    public static void main(String[] args) {
        UserSearch userSearch = new UserSearch();
        DirContextOperations result = userSearch.searchForUser("testUser");
        if (result != null) {
            System.out.println("User found: " + result.getAttributes());
        } else {
            System.out.println("User not found.");
        }
    }
}