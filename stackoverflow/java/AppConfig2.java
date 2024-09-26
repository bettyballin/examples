// The given snippet seems to be an XML configuration, typically used in Spring Framework configuration files, not a Java code snippet.
// As such, it cannot be directly refactored into a Java code snippet that can be compiled. It is already in the correct format for its intended purpose.
// If you need to set a property of a bean in Java config, you can use something like the following:

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AppConfig2 {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
        return authenticationConfiguration.authenticationManager();
    }
}