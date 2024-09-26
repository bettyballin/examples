import org.springframework.security.config.annotation.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

public class CustomSecurityConfigurer<H extends HttpSecurityBuilder<H>>
        extends AbstractHttpConfigurer<CustomSecurityConfigurer<H>, H> {

    @Override
    public void init(H http) {
        // No initialization needed for this configurer
    }

    @Override
    public void configure(H http) {
        // add your own filter... for example:
        http.addFilterAfter(new ImportantFilter(), LogoutFilter.class);
    }

    private static class ImportantFilter extends LogoutFilter {
        // Implement the filter logic here
    }
}