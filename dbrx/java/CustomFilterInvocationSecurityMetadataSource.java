import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSourceAdvisor;
import org.springframework.security.access.method.MethodSecurityMetadataSourceMethodInterceptor;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;

public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // Get the URL from the request (object)
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        String url = getRequestUrl(request);

        // Check if user has access to this URL based on their granted authorities/roles
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            for (GrantedAuthority authority : auth.getAuthorities()) {
                if (hasAccess(authority, url)) {
                    return AuthorityUtils.createAuthorityList(authority.getAuthority());
                }
            }
        }

        // If no access is found deny all by default
        return Collections.singletonList(new ConfigAttribute() {
            @Override
            public String getAttribute() {
                return "DENY_ALL";
            }
        });
    }

    private boolean hasAccess(GrantedAuthority authority, String url) {
        // Implement your logic here to check if the user with this granted authority/role can access the URL.
        // You could use a map or database lookup for example.

        // For demonstration purposes:
        return "ROLE_USER".equals(authority.getAuthority()) && "/user/home".equals(url);
    }

    private String getRequestUrl(HttpServletRequest request) {
        StringBuilder url = new StringBuilder();
        url.append(request.getRequestURI());

        if (request.getQueryString() != null) {
            url.append('?').append(request.getQueryString());
        }

        return url.toString();
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    // Implement other methods as needed
}