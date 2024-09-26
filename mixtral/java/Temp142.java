import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.access.expression.method.PreInvocationAuthorizationAdviceVoter;
import org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VendorPermission {
    String permission();
}

@Aspect
@Component
class PermissionCheckingAspect {

    private final ExpressionBasedPreInvocationAdvice preAuthorization;

    public PermissionCheckingAspect(ExpressionBasedPreInvocationAdvice preAuthorization) {
        this.preAuthorization = preAuthorization;
    }

    @Around("@annotation(vendorPermission)")
    public Object checkPermissions(ProceedingJoinPoint pjp, VendorPermission vendorPermission) throws Throwable {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();

        if (!auth.isAuthenticated()) {
            throw new AccessDeniedException("Not authenticated!");
        }

        Object[] args = pjp.getArgs();
        String permissionExpression = "hasRole('ROLE_VENDOR') and hasPermission(#product, '" + vendorPermission.permission() + "')";
        MethodInvocation methodInv = (MethodInvocation) ReflectionUtils.findMethod(pjp.getTarget().getClass(), pjp.getSignature().getName(), (Class<?>[]) args);

        preAuthorization.setSecureObjectClass(methodInv.getMethod().getDeclaringClass());
        
        if (auth.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
            return pjp.proceed();
        }

        if (!preAuthorization.before(methodInv, (FilterInvocation) pjp.getThis(), auth)) {
            throw new AccessDeniedException("Access denied!");
        }

        return pjp.proceed();
    }
}