import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public class Temp1742 {
    public static void main(String[] args) {
        // This is a placeholder main method
        System.out.println("Spring Security Configuration Example");
    }
}

@Service
class YourUserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) {
        // Implement your user details retrieval logic here
        return org.springframework.security.core.userdetails.User.withUsername(username).password("password").roles("USER").build();
    }
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private YourUserDetailService yourUserDetailService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        // Set the default password encoder
        PasswordEncoder pe = new BCryptPasswordEncoder();
        auth.userDetailsService(yourUserDetailService).passwordEncoder(pe);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}