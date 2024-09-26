import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

interface MethodInvocation {
    Object getThis();
    Method getMethod();
    Object[] getArguments();
}

public class Temp1543 {
    public static void main(String[] args) {
        MethodInvocation invocation = new MethodInvocation() {
            @Override
            public Object getThis() {
                return new ExampleClass();
            }

            @Override
            public Method getMethod() {
                try {
                    return ExampleClass.class.getMethod("exampleMethod", String.class, int.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public Object[] getArguments() {
                return new Object[]{"Hello", 123};
            }
        };

        Object targetObj = invocation.getThis();
        Class<?> clazz = targetObj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(invocation.getMethod().getName())) {

                // Get argument types and names
                Class<?>[] argTypes = method.getParameterTypes();
                Parameter[] parameters = method.getParameters();

                Object[] args = invocation.getArguments();
                for (int i = 0; i < args.length; ++i) {
                    System.out.println("Argument " + i +
                            ": Type=" + argTypes[i].getName() +
                            " Name=" + parameters[i].getName());
                }
            }
        }
    }
}

class ExampleClass {
    public void exampleMethod(String param1, int param2) {
        // Example method
    }
}