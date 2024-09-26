import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class Temp3669 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3669.class, args);
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(AuthenticationManager authManager) {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http
                    .csrf().disable()
                    .authenticationManager(authManager)
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                    .addFilter(new JwtUserNameAndPasswordAuthFilter(authManager))
                    .authorizeRequests()
                        .antMatchers("/", "/index.html", "/css/*", "/js/*").permitAll()
                        .antMatchers("/api/**").hasRole("STUDENT")
                        .anyRequest().authenticated();
            }
        };
    }
}

// Assuming JwtUserNameAndPasswordAuthFilter is defined elsewhere in your code.