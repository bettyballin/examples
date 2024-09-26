import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

public class Temp928 extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public Temp928(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
        auth
          .jdbcAuthentication()
          .dataSource(dataSource)
          .usersByUsernameQuery(getUserQuery())
          .authoritiesByUsernameQuery(getAuthoritiesQuery())
          .passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private String getUserQuery() {
        return "SELECT username, password, enabled FROM users WHERE username = ?";
    }

    private String getAuthoritiesQuery() {
        return "SELECT username, authority FROM authorities WHERE username = ?";
    }

    public static void main(String[] args) {
        // This is just a placeholder main method
        // Spring Boot application would normally be started with SpringApplication.run(Temp928.class, args)
        System.out.println("Application started");
    }
}