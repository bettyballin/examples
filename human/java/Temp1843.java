import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor(AccessDecisionManager accessDecisionManager, AuthenticationManager authenticationManager) {
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setSecurityMetadataSource(securityMetadataSource());
        filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager);
        filterSecurityInterceptor.setAuthenticationManager(authenticationManager);
        return filterSecurityInterceptor;
    }

    @Bean
    public org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource securityMetadataSource() {
        Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();
        requestMap.put(new AntPathRequestMatcher("/login.htm*"), SecurityConfig.createList("ROLE_ANONYMOUS"));
        requestMap.put(new AntPathRequestMatcher("/**"), SecurityConfig.createList("ROLE_USER", "ROLE_ADMIN"));
        return new org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource(requestMap);
    }

    private static Collection<ConfigAttribute> createList(String... roles) {
        List<ConfigAttribute> attributes = new ArrayList<>();
        for (String role : roles) {
            attributes.add(new SecurityConfig(role));
        }
        return attributes;
    }
}