import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig183urerAdapter;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;

@EnableWebSecurity
public class SecurityConfig183 extends WebSecurityConfig183urerAdapter {

    private final RelyingPartyRegistrationRepository relyingPartyRegistrationRepository;

    public SecurityConfig183(RelyingPartyRegistrationRepository relyingPartyRegistrationRepository) {
        this.relyingPartyRegistrationRepository = relyingPartyRegistrationRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .antMatchers("/css/**", "/index").permitAll()
                    .antMatchers("/user/**").hasRole("USER")
            )
            .saml2Login(saml2Login ->
                saml2Login
                    .relyingPartyRegistrationRepository(relyingPartyRegistrationRepository)
            );
    }
}