import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.access.expression.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.access.expression.method.MethodSecurityExpressionRoot;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.ExpressionUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.RoleHierarchy;
import org.springframework.security.access.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInvocation;

public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication);
        root.setThis(invocation.getThis());
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(getTrustResolver());
        root.setRoleHierarchy(getRoleHierarchy());
        return root;
    }

    private class CustomMethodSecurityExpressionRoot extends MethodSecurityExpressionRoot {

        public CustomMethodSecurityExpressionRoot(Authentication authentication) {
            super(authentication);
        }

        public void evaluate(String expression, Method method, Authentication authentication) {
            StandardEvaluationContext context = new StandardEvaluationContext();
            context.setRootObject(this);
            context.setVariable("args", method.getParameters());
            SpelExpressionParser parser = new SpelExpressionParser();
            boolean result = parser.parseExpression(expression).getValue(context, Boolean.class);
            if (!result) {
                throw new AccessDeniedException("Access denied");
            }
        }
    }
}