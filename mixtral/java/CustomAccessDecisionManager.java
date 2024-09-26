import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.prepost.PrePostAnnotationSecurityMetadataSource;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class SecurityConfig {

    @Bean
    public MethodInterceptor securityMethodInterceptor() {
        return new MethodSecurityInterceptor() {
            {
                setAccessDecisionManager(new AffirmativeBased(Collections.singletonList(new CustomAccessDecisionManager())));
                setSecurityMetadataSource(new PrePostAnnotationSecurityMetadataSource((MethodSecurityMetadataSource) null));
            }
        };
    }

    // This is a custom access decision manager
    private static class CustomAccessDecisionManager implements AccessDecisionVoter<Object> {

        @Override
        public boolean supports(ConfigAttribute attribute) {
            return true;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            return true;
        }

        @Override
        public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
            for (ConfigAttribute attr : attributes) {
                if (!attr.getAttribute().startsWith("ROLE_")) continue;

                // Check the role
                boolean hasRole = authentication.getAuthorities()
                        .stream()
                        .anyMatch(granted -> granted.getAuthority().equalsIgnoreCase(attr.getAttribute()));

                if (hasRole) return ACCESS_GRANTED;
            }

            // If we get here the user doesn't have any of these roles
            return ACCESS_DENIED;
        }
    }

    public static void main(String[] args) {
        // Test or run the application
    }
}