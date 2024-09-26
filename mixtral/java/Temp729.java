import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class Temp729 {

    public static void main(String[] args) {
        Temp729 temp = new Temp729();
        try {
            UserDetails user = temp.loadUserByUsername("username");
            System.out.println("User loaded: " + user.getUsername());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Simulate a SOAP web service call here to get user details including their role
        Set<Role> rolesFromWebServiceCall = new HashSet<>();
        rolesFromWebServiceCall.add(new Role("ROLE_USER"));
        rolesFromWebServiceCall.add(new Role("ROLE_ADMIN"));

        Set<GrantedAuthority> grantedAuths = new HashSet<>();

        for (Role role : rolesFromWebServiceCall) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getCode());
            grantedAuths.add(authority);
        }

        return new User(username, "password", true, true, true, true, grantedAuths);
    }

    class Role {
        private String code;

        public Role(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}