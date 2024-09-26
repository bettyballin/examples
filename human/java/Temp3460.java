import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.saml2.provider.service.authentication.OpenSamlAuthenticationProvider;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.security.saml2.provider.service.web.authentication.Saml2LoginConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticationRequestContext;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticationResponse;
import org.springframework.security.saml2.provider.service.web.authentication.logout.Saml2LogoutConfigurer;

import java.util.Collection;

public class Temp3460 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .saml2Login()
            .authenticationManager(
                new ProviderManager(
                    new OpenSamlAuthenticationProvider() {
                        @Override
                        public Saml2Authentication authenticate(Saml2AuthenticationToken authentication) {
                            // Custom authentication logic
                            return super.authenticate(authentication);
                        }

                        @Override
                        public Collection<? extends GrantedAuthority> extractAuthorities(Saml2AuthenticationResponse response) {
                            // return a list of authorities based on the assertion
                            return super.extractAuthorities(response);
                        }
                    }
                )
            );
    }

    public static void main(String[] args) {
        // You may need to run the Spring Application context for this to take effect
    }
}