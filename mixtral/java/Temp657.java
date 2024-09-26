import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp657 implements UserDetailsService {

    public static void main(String[] args) {
        Temp657 temp = new Temp657();
        try {
            UserDetails user = temp.loadUserByUsername("user");
            System.out.println(user);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ...

        String hashedPwd = new BCryptPasswordEncoder().encode("plainTextPassword");

        return User
                .withUsername(username)
                .password(hashedPwd)
                .roles("USER")
                .build();
    }
}