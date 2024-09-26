import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.userdetails.InetOrgPersonContextMapper;

@SpringBootApplication
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationSecurity.class, args);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .ldapAuthentication()
            .userDnPatterns("uid={0},ou=people")
            .groupSearchBase("ou=groups")
            .contextSource()
            .url("ldap://localhost:8389/dc=springframework,dc=org")
            .and()
            .userDetailsContextMapper(new InetOrgPersonContextMapper())
            .passwordCompare()
            .passwordEncoder(passwordEncoder())
            .passwordAttribute("userPassword");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}