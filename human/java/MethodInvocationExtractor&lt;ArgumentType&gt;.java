import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodInvocationExtractor<ArgumentType> {

    private MethodInvocation methodInvocation;

    public MethodInvocationExtractor(MethodInvocation methodInvocation) {
        this.methodInvocation = methodInvocation;
    }

    public ArgumentType getArg(int num) {
        try {
            Object[] arguments = methodInvocation.getArguments();
            return (ArgumentType) arguments[num];
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalStateException();
        }
    }

    public static void main(String[] args) {
        MethodInvocation methodInvocation = new MethodInvocation() {
            @Override
            public Method getMethod() {
                try {
                    return this.getClass().getMethod("dummyMethod", String.class, Integer.class);
                } catch (NoSuchMethodException e) {
                    return null;
                }
            }

            @Override
            public Object[] getArguments() {
                return new Object[]{"test", 123};
            }

            @Override
            public Object proceed() throws Throwable {
                return null;
            }

            @Override
            public Object getThis() {
                return this;
            }

            @Override
            public AccessibleObject getStaticPart() {
                return getMethod();
            }
        };

        MethodInvocationExtractor<String> extractor = new MethodInvocationExtractor<>(methodInvocation);
        System.out.println(extractor.getArg(0));  // Output: test

        MethodInvocationExtractor<Integer> extractorInt = new MethodInvocationExtractor<>(methodInvocation);
        System.out.println(extractorInt.getArg(1));  // Output: 123
    }

    // Dummy method to satisfy getMethod() implementation
    public void dummyMethod(String arg1, Integer arg2) {
    }
}