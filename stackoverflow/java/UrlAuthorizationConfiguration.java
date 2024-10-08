import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.Filter;
import java.util.List;
import java.util.Optional;

@Configuration
public class UrlAuthorizationConfiguration {

    @Bean
    public UrlAuthorization urlAuthorization(List<Filter> filters) {
        FilterSecurityInterceptor interceptor = getInterceptor(filters)
                .orElseThrow(() -> new BeanCreationException("Could not get security interceptor"));

        return new UrlAuthorization(
                interceptor.getSecurityMetadataSource(),
                interceptor.getAccessDecisionManager()
        );
    }

    private Optional<FilterSecurityInterceptor> getInterceptor(List<Filter> filters) {
        for (Filter filter : filters) {
            if (filter instanceof FilterChainProxy) {
                for (SecurityFilterChain chain : ((FilterChainProxy) filter).getFilterChains()) {
                    for (Filter securityFilter : chain.getFilters()) {
                        if (securityFilter instanceof FilterSecurityInterceptor) {
                            return Optional.of((FilterSecurityInterceptor) securityFilter);
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }
}