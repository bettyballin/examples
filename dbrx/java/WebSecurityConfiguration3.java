import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final SbbolClientProperties sbbolClientProperties;

    public WebSecurityConfiguration(SbbolClientProperties sbbolClientProperties) {
        this.sbbolClientProperties = sbbolClientProperties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // your existing configuration

        OAuth2LoginConfigurer<HttpSecurity> oauth2LoginConfigurer = new OAuth2LoginConfigurer<>();

        ClientRegistration clientRegistration = CommonOAuth2Provider.GITHUB
                .getBuilder("sbbol")
                .clientId(sbbolClientProperties.getClientId())
                .clientSecret(sbbolClientProperties.getClientSecret())
                // other properties
                .build();

        oauth2LoginConfigurer.clientRegistrationRepository(
                new InMemoryClientRegistrationRepository(clientRegistration)
        );
        http.oauth2Login(oauth2LoginConfigurer);
    }
}