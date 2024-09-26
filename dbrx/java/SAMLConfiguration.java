import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.saml2.provider.service.authentication.OpenSaml4AuthenticationProvider;
import org.springframework.security.saml2.provider.service.metadata.OpenSamlMetadataResolver;
import org.springframework.security.saml2.provider.service.metadata.Saml2MetadataFilter;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.web.Saml2WebSsoAuthenticationFilter;
import org.springframework.security.saml2.provider.service.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;

@Configuration
@EnableWebSecurity
public class SAMLConfiguration {

    @Autowired
    private SetToken token;

    @Autowired
    private RelyingPartyRegistrationRepository relyingPartyRegistrationRepository;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        OpenSaml4AuthenticationProvider authenticationProvider = new OpenSaml4AuthenticationProvider();

        Saml2MetadataFilter filter = new Saml2MetadataFilter(relyingPartyRegistrationRepository, new OpenSamlMetadataResolver());
        http.addFilterBefore(filter, Saml2WebSsoAuthenticationFilter.class);

        CustomSaml2AuthenticationSuccessHandler successHandler = new CustomSaml2AuthenticationSuccessHandler(token);

        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/saml2/service-provider-metadata/**")
                        .permitAll()
        )
        .addFilterAfter(token, Saml2WebSsoAuthenticationFilter.class)
        .addFilterAfter(new SecurityContextHolderAwareRequestFilter(), SecurityContextHolderFilter.class)
        .saml2Login(saml2 -> saml2
                .authenticationManager(new ProviderManager(authenticationProvider))
                .relyingPartyRegistrationRepository(relyingPartyRegistrationRepository)
                .successHandler(successHandler)
        )
        .saml2Logout(withDefaults());

        return http.build();
    }
}