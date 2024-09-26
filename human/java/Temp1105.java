public class Temp1105 {
    public static void main(String[] args) {
        // Create a sample method invocation with a Long argument
        MethodInvocation<Long> methodInvocation = new MethodInvocation<>(123L);
        
        // Create an extractor for the MethodInvocation
        MethodInvocationExtractor<Long> extractor = new MethodInvocationExtractor<>(methodInvocation);
        
        // Get the argument at index 0
        Long id = extractor.getArg(0);
        
        // Print the extracted argument
        System.out.println("Extracted argument: " + id);
    }
}

// Assuming a simple MethodInvocation class
class MethodInvocation<T> {
    private final T argument;

    public MethodInvocation(T argument) {
        this.argument = argument;
    }

    public T getArgument() {
        return argument;
    }
}

// MethodInvocationExtractor class
class MethodInvocationExtractor<T> {
    private final MethodInvocation<T> methodInvocation;

    public MethodInvocationExtractor(MethodInvocation<T> methodInvocation) {
        this.methodInvocation = methodInvocation;
    }

    public T getArg(int index) {
        if (index != 0) {
            throw new IndexOutOfBoundsException("Only one argument is supported.");
        }
        return methodInvocation.getArgument();
    }
}