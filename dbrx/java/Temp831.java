import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp831 {
    public static void main(String[] args) {
        // Simulate Authentication object for demonstration purposes
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Check if Authentication object is not null
        if (auth != null) {
            String username = auth.getName();
            System.out.println("Username: " + username);
        } else {
            System.out.println("No authentication information available.");
        }
    }
}


Won't compile because of the Spring dependencies. Let's add them:

pom.xml (if you're using Maven):
xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-security-core</artifactId>
        <version>5.7.4</version>
    </dependency>
</dependencies>


build.gradle (if you're using Gradle):
groovy
dependencies {
    implementation 'org.springframework:spring-security-core:5.7.4'
}


SecurityContextHolder needs an application context to work. Let's add a basic Spring Security configuration:


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        return manager;
    }
}


We also need to create an application context:


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Temp831 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecurityConfig.class);
        SecurityContextHolder.setContext(new SecurityContextImpl());

        // Simulate Authentication object for demonstration purposes
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Check if Authentication object is not null
        if (auth != null) {
            String username = auth.getName();
            System.out.println("Username: " + username);
        } else {
            System.out.println("No authentication information available.");
        }
    }
}


SecurityContextHolder needs a SecurityContext to work. We set a SecurityContextImpl here.

But still it will not have authentication object set. You can't just directly get the authentication object without authenticating the user. You need to authenticate the user first. 


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;

public class Temp831 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecurityConfig.class);
        SecurityContextHolder.setContext(new SecurityContextImpl());

        // get userDetailsService
        UserDetailsService userDetailsService = context.getBean(UserDetailsService.class);

        // authenticate user
        String username = "user";
        String password = "password";
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // set authentication
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(token);
        SecurityContextHolder.setContext(securityContext);

        // get authentication
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Check if Authentication object is not null
        if (auth != null) {
            String username1 = auth.getName();
            System.out.println("Username: " + username1);
        } else {
            System.out.println("No authentication information available.");
        }
    }
}

Now this should compile and also will have the authentication object set.