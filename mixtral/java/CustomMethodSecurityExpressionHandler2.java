import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionRoot;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Collection;

public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
    private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        StandardEvaluationContext context = new StandardEvaluationContext();

        // Set the current user's privileges
        Collection<GrantedAuthority> authorities = (authentication == null ? AuthorityUtils.NO_AUTHORITIES : authentication.getAuthorities());

        boolean adminRole = false;

        for (GrantedAuthority authority : authorities) {
            if ("ROLE_ADMIN".equalsIgnoreCase(authority.getAuthority())) {
                adminRole = true;
                break;
            }
        }

        context.setVariable("hasPrivilege", new PrivilegeEvaluator());

        return new CustomMethodSecurityExpressionRoot(authentication) {

            @Override
            public boolean hasPermission(Object target, Object permission) {
                // Implement your custom logic here

                if (target instanceof Message && "PRIV_READ_MESSAGE".equalsIgnoreCase((String) permission))
                    return adminRole || ((Message) target).getUser().getId().equals(getAuthentication().getName());

                throw new IllegalArgumentException("hasPermission not supported for object " + target);
            }
        };
    }

    private class PrivilegeEvaluator {
        // Implement the privilege evaluator logic if needed
    }

    private class CustomMethodSecurityExpressionRoot extends MethodSecurityExpressionRoot {
        public CustomMethodSecurityExpressionRoot(Authentication authentication) {
            super(authentication);
        }

        @Override
        public boolean hasPermission(Object target, Object permission) {
            // Default implementation
            return false;
        }
    }

    // Assuming a simple Message class
    private class Message {
        private User user;

        public User getUser() {
            return user;
        }
    }

    // Assuming a simple User class
    private class User {
        private String id;

        public String getId() {
            return id;
        }
    }
}