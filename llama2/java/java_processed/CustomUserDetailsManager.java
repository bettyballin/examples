import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.ContextSource;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;

public class CustomUserDetailsManager extends LdapUserDetailsManager {

  public CustomUserDetailsManager(ContextSource contextSource) {
    super(contextSource);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    // custom logic to retrieve the user from AD
    return super.loadUserByUsername(username);
  }

  public static void main(String[] args) {
    // Example usage
    LdapContextSource contextSource = new LdapContextSource();
    contextSource.setUrl("ldap://localhost:389");
    contextSource.setBase("dc=example,dc=com");
    contextSource.setUserDn("cn=admin,dc=example,dc=com");
    contextSource.setPassword("password");

    contextSource.afterPropertiesSet();

    CustomUserDetailsManager manager = new CustomUserDetailsManager(contextSource);
    try {
      UserDetails user = manager.loadUserByUsername("john.doe");
      System.out.println("User found: " + user.getUsername());
    } catch (UsernameNotFoundException | DataAccessException e) {
      e.printStackTrace();
    }
  }
}