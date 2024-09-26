import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Temp2315 {
    public static void main(String[] args) {
        // Assuming MethodInvocation is a custom or third-party class
        MethodInvocation mi = getMethodInvocation(); // Placeholder method to get MethodInvocation instance
        Object[] arguments = mi.getArguments();
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(mi.getThis());

        // Get method
        Method specificMethod = null;
        for (Method m : targetClass.getMethods()) {
            if (!m.getName().equalsIgnoreCase("your_method")) continue;

            Class<?>[] parameterTypes = m.getParameterTypes();

            // Check number of parameters
            if (parameterTypes.length != arguments.length)
                continue;

            specificMethod = m;
            break;
        }

        if (specificMethod == null) {
            System.out.println("Method not found");
            return;
        }

        // Get argument names and types
        for (int i = 0; i < arguments.length; ++i) {
            System.out.println("Argument " + i);

            // Argument type
            Class<?> parameterType = specificMethod.getParameterTypes()[i];

            if (parameterType != null)
                System.out.print("\t Type: " + parameterType.getName());

            // Get argument name
            Parameter[] parameters = specificMethod.getParameters();

            for (int j = 0; j < parameters.length; ++j) {
                if (parameterType == parameters[j].getType()) {
                    System.out.print("\t Name: " + parameters[j].getName());

                    // Get argument value
                    Object argValue = arguments[i];
                    System.out.println("\t Value: " + argValue);

                    break;
                }
            }
        }
    }

    // Placeholder method to simulate getting a MethodInvocation instance
    private static MethodInvocation getMethodInvocation() {
        // Implement this method to return a valid MethodInvocation instance
        return null;
    }
}

// Placeholder classes to make the code compile
class MethodInvocation {
    public Object[] getArguments() {
        return new Object[0];
    }

    public Object getThis() {
        return new Object();
    }
}

class AopProxyUtils {
    public static Class<?> ultimateTargetClass(Object proxy) {
        return proxy.getClass();
    }
}