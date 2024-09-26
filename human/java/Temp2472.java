public class Temp2472 {
    public static void main(String[] args) {
        // Since the original code appears to be a part of a Spring Security configuration,
        // we'll provide a minimal setup for a Spring Boot application
        // with a login page configuration.

        // However, note that this cannot be directly run as a standalone Java application.
        // It needs a Spring Boot context to be meaningful.

        // The following is a basic Spring Boot application setup for context.
        SpringApplication.run(Temp2472Application.class, args);
    }
}

// Spring Boot Application Class
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp2472Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp2472Application.class, args);
    }
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll();
    }
}


**Note**: This code provides a minimal Spring Boot application setup necessary to make the original code snippet meaningful. For a complete working application, additional configurations and dependencies in the `pom.xml` or `build.gradle` file are required.