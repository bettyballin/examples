import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2438 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // The main method can be used to launch a Spring Boot application if needed
        // SpringApplication.run(Temp2438.class, args);
        System.out.println("Application started");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/oauth/token/revokeById/**").permitAll()
                .antMatchers("/tokens/**").permitAll().anyRequest().authenticated().and().formLogin().permitAll().and()
                .csrf().disable();
        // @formatter:on
    }
}