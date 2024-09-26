import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CustomMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        // Your custom authorization logic here

        return invocation.proceed();
    }

    public static void main(String[] args) {
        // Example usage
        CustomMethodInterceptor interceptor = new CustomMethodInterceptor();
        // Simulate a MethodInvocation here if needed for testing
    }
}