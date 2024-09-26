import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.FilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SamlWebSSOProcessingFilter;
import org.springframework.security.saml.SAMLDiscovery;

public class Temp436 {
    public static void main(String[] args) {
        // Example usage
        Temp436 temp = new Temp436();
        FilterChain filterChain = temp.getFilterChain("/sso/idp");
        System.out.println("Filter chain created with IDP SSO URL: /sso/idp");
    }

    private FilterChain getFilterChain(String idpSsoUrl) {
        // Create a new filter chain
        FilterChainProxy filterChain = new FilterChainProxy();

        // Add the IDP discovery filter
        filterChain.addFilter(new SAMLDiscovery());

        // Add the WebSSO processing filter
        filterChain.addFilter(new SamlWebSSOProcessingFilter());

        // Add a request matcher that matches the IDP SSO URL
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(idpSsoUrl + "/**");
        filterChain.addMatcher(matcher);

        return filterChain;
    }
}