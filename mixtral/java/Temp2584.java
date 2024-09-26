import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Temp2584 {

    public static void main(String[] args) {
        // Typically, Spring Boot applications are run through Spring Boot's main method,
        // but this is just a placeholder to make this class executable.
        System.out.println("Security configuration loaded.");
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests((requests) ->
                requests
                    // permit all for home
                    .antMatchers("/home").permitAll()
                    // authenticated access to /item/**
                    .antMatchers("/item/**").authenticated()
                    // any other request requires authentication
                    .anyRequest().authenticated()
            )
            .formLogin();
        return http.build();
    }
}