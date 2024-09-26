import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

public class MyConfiguration {

    private static final String REMEMBERME_KEY = "myAppKey"; // Or whatever your key is
    private FormUserDetailsService formUserDetailsService; // Assuming this is defined elsewhere

    @Bean
    public PersistentTokenBasedRememberMeServices myRememberMeServices() {
        PersistentTokenBasedRememberMeServices service = new PersistentTokenBasedRememberMeServices(REMEMBERME_KEY, formUserDetailsService, null); // null for tokenRepository
        service.setAlwaysRemember(true);
        service.setCookieName("xxxx");
        service.setParameter("_spring_security_remember_me");
        service.setTokenValiditySeconds(123);
        return service;
    }

    // Other beans and methods
}