import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.allowFormAuthenticationForClients().addTokenEndpointAuthenticationFilter(new AligenieFilter());
    }

    // Assuming AligenieFilter is a class you have defined elsewhere
    public class AligenieFilter extends javax.servlet.Filter {
        // Implement the required methods for the filter
        @Override
        public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)
                throws java.io.IOException, javax.servlet.ServletException {
            // Filter logic goes here
            chain.doFilter(request, response);
        }

        @Override
        public void init(javax.servlet.FilterConfig filterConfig) throws javax.servlet.ServletException {
            // Initialization logic
        }

        @Override
        public void destroy() {
            // Cleanup logic
        }
    }
}