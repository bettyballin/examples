import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.springframework.ldap.core.LdapTemplate;

public class Temp1214 {
    public static void main(String[] args) {
        LdapTemplate ldapTemplate = new LdapTemplate();
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        String filter = "(&(objectClass=group)(member={0}))";

        try {
            NamingEnumeration<SearchResult> results = ldapTemplate.search(
                "DC=ah1,DC=ad,DC=megacorp,DC=com",
                filter,
                controls,
                new Object[] { "CN=Adam,OU=Users,DC=ah1,DC=ad,DC=megacorp,DC=com" }
            );

            while (results.hasMore()) {
                SearchResult result = results.next();
                System.out.println(result.getNameInNamespace());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}