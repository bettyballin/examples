import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp2480 implements UserDetailsService {

    public static void main(String[] args) {
        Temp2480 temp = new Temp2480();
        UserDetails user = temp.loadUserByUsername("username");
        System.out.println(user);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Normally you would fetch user details from a database, here it's hardcoded for demonstration
        String rawPassword = "password";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
        
        return User.builder()
                .username(username)
                .password(encodedPassword)
                .roles("USER")
                .build();
    }
}