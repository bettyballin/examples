// The provided code snippet contains XML configuration meant for a Spring Security context. 
// It cannot be directly included in a Java class. Below is an executable Java code with a simple main method.

public class Temp1558 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}


If you need a full Spring Security configuration, this would typically be placed in an XML configuration file, not directly in the Java code. Here's how you might create a simple Spring Boot application with Spring Security enabled using Java code instead of XML:


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp1558Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp1558Application.class, args);
    }

    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .and()
                .httpBasic();
        }

        @Bean
        public CustomMethodSecurityExpressionHandler expressionHandler() {
            return new CustomMethodSecurityExpressionHandler();
        }
    }

    public static class CustomMethodSecurityExpressionHandler extends org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler {
        // Custom method security logic can be added here.
    }
}

This code sets up a basic Spring Boot application with Spring Security and method security enabled.