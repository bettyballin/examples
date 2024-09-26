import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
public class OAuth2SsoConfiguration extends WebSecurityConfigurerAdapter {

    private final RequestMatcher authorizationHeaderRequestMatcher;
    private final CorsFilter corsFilter;
    private final OAuth2ClientContextFilter oAuth2ClientContextFilter;

    public OAuth2SsoConfiguration(
        @Qualifier("authorizationHeaderRequestMatcher") RequestMatcher authorizationHeaderRequestMatcher,
        CorsFilter corsFilter,
        OAuth2ClientContextFilter oAuth2ClientContextFilter
    ) {
        this.authorizationHeaderRequestMatcher = authorizationHeaderRequestMatcher;
        this.corsFilter = corsFilter;
        this.oAuth2ClientContextFilter = oAuth2ClientContextFilter;

        oAuth2ClientContextFilter.setRedirectStrategy(new RedirectStrategy() {

            @Override
            public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
                // My Code Here
            }

        });
    }
}