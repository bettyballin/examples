public class MethodInvocationExtractor1<T> {
    private MethodInvocation methodInvocation;

    public MethodInvocationExtractor1(MethodInvocation methodInvocation) {
        this.methodInvocation = methodInvocation;
    }

    public T getArg(int index) {
        if (index >= 0 && index < methodInvocation.getArguments().size()) {
            return (T) methodInvocation.getArguments().get(index);
        }
        return null;
    }
}

class MethodInvocation {
    // Mocking a method invocation class with getArguments method.
    public List<Object> getArguments() {
        // In a real scenario, this would return the arguments of the method invocation.
        return new ArrayList<>();
    }
}

class Main {
    public static void main(String[] args) {
        MethodInvocation methodInvocation = new MethodInvocation();
        MethodInvocationExtractor1<Long> extractor = new MethodInvocationExtractor1<>(methodInvocation);
        Long id = extractor.getArg(0);
        // Further operations with id
    }
}