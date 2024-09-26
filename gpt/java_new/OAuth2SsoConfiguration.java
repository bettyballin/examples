import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.CorsFilter;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableWebSecurity
@Configuration
public class OAuth2SsoConfiguration extends WebSecurityConfigurerAdapter {

    private final RequestMatcher authorizationHeaderRequestMatcher;
    private final CorsFilter corsFilter;
    private final Logger log = LoggerFactory.getLogger(OAuth2SsoConfiguration.class);

    @Autowired
    private OAuth2ClientContextFilter oAuth2ClientContextFilter;

    public OAuth2SsoConfiguration(@Qualifier("authorizationHeaderRequestMatcher") RequestMatcher authorizationHeaderRequestMatcher,
                                  CorsFilter corsFilter) {
        this.authorizationHeaderRequestMatcher = authorizationHeaderRequestMatcher;
        this.corsFilter = corsFilter;
    }

    @PostConstruct
    public void init() {
        log.info("OAuth2SsoConfiguration initialized");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(authorizationHeaderRequestMatcher)
            .addFilterBefore(corsFilter, BasicAuthenticationFilter.class)
            .addFilterBefore(oAuth2ClientContextFilter, CorsFilter.class)
            .authorizeRequests()
            .anyRequest().authenticated();
    }
}