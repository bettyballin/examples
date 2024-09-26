import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.saml2.provider.service.authentication.OpenSaml4AuthenticationProvider;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3462 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .saml2Login()
            .authenticationManager(new ProviderManager(
                new OpenSaml4AuthenticationProvider() {
                    @Override
                    public Saml2Authentication convert(org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticationToken token) {
                        Saml2Authentication defaultAuth = OpenSaml4AuthenticationProvider.createDefaultResponseAuthenticationConverter().convert(token);
                        if (defaultAuth != null && defaultAuth.isAuthenticated()) {
                            // Create a list of authorities based on the assertion
                            // For example, you can extract roles from the SAML assertions and create GrantedAuthority list
                            // Here we are just creating an empty list for demonstration purposes
                            java.util.List<org.springframework.security.core.GrantedAuthority> authoritiesList = new java.util.ArrayList<>();
                            return new Saml2Authentication((AuthenticatedPrincipal) defaultAuth.getPrincipal(), defaultAuth.getSaml2Response(), authoritiesList);
                        } else {
                            return defaultAuth;
                        }
                    }
                }
            ));
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Temp3462.class, args);
    }
}


To make this code executable, you would need to set up a Spring Boot application and include the necessary dependencies for Spring Security and SAML.