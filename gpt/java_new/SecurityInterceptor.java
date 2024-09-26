import javax.interceptor.Interceptor;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Interceptor
public class SecurityInterceptor {

    @AroundInvoke
    public Object checkSecurity(InvocationContext context) throws Exception {
        // Extract the @Restrict annotation and perform your security checks
        Restrict restrict = context.getMethod().getAnnotation(Restrict.class);
        if (restrict != null) {
            // Perform security checks based on restrict.roleType() and restrict.roleLevel()
            // TODO: Implement security check logic here
        }
        return context.proceed();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface Restrict {
    RoleType roleType();
    String roleLevel();
}

enum RoleType {
    ALL, USER, ADMIN // Assuming these are the role types required
}