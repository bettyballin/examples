import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

public class Temp2161 {

    @Autowired
    private LdapContextSource ldapContextSource;

    public UserDetailsManager getUserDetailsManager() {
        return new LdapUserDetailsManager(ldapContextSource);
    }

    public void changeUserPassword(String oldPassword, String newPassword) {
        UserDetailsManager userDetailsManager = getUserDetailsManager();
        userDetailsManager.changePassword(oldPassword, newPassword);
    }

    public static void main(String[] args) {
        Temp2161 temp = new Temp2161();

        // Assuming the ldapContextSource is initialized properly elsewhere in the application context
        temp.ldapContextSource = new LdapContextSource();
        temp.ldapContextSource.setUrl("ldap://localhost:389");
        temp.ldapContextSource.setBase("dc=example,dc=com");
        // Set additional properties as needed
        temp.ldapContextSource.afterPropertiesSet();

        temp.changeUserPassword("old_password", "new_password");
    }
}