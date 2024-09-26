import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Sso;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.oauth2.config.annotation.web.configuration.OAuth2SsoDefaultConfiguration;

@SpringBootApplication
public class CustomOauth2SsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomOauth2SsoApplication.class, args);
    }

    @Configuration
    @EnableOAuth2Sso
    public static class CustomOauth2SsoConfig extends OAuth2SsoDefaultConfiguration {

        @Override
        protected AuthenticationSuccessHandler successHandler() {
            SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
            handler.setDefaultTargetUrl("/index.html");
            return handler;
        }
    }
}