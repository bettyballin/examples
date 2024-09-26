import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.stereotype.Component;
import org.springframework.expression.Expression;
import org.springframework.expression.EvaluationContext;

import java.util.Optional;

@Aspect
@Component
public class PostFilterOptionalAspect {

    @Autowired
    private MethodSecurityExpressionHandler expressionHandler;

    @AfterReturning(pointcut = "execution(* *(..)) && @annotation(org.springframework.security.access.prepost.PostFilter)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        if (result instanceof Optional<?>) {
            Optional<?> optionalResult = (Optional<?>) result;
            optionalResult.ifPresent(value -> {
                SecurityContext context = SecurityContextHolder.getContext();
                Authentication authentication = context.getAuthentication();
                Expression expression = expressionHandler.getExpressionParser().parseExpression("YOUR_SECURITY_EXPRESSION");
                EvaluationContext evaluationContext = expressionHandler.createEvaluationContext(authentication, joinPoint);
                // Additional logic to apply the security expression to the value
            });
        }
    }
}