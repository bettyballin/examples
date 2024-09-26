import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp2929 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp2929.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers() //1
                .antMatchers("/login", "/oauth/authorize") //2
                .and() //3
            .authorizeRequests() //4
                .anyRequest() //5
                .authenticated(); //6
    }

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        // In-memory user details manager for testing
        org.springframework.security.provisioning.InMemoryUserDetailsManager manager = new org.springframework.security.provisioning.InMemoryUserDetailsManager();
        manager.createUser(org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build());
        return manager;
    }
}