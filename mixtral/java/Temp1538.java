import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Temp1538 {

    static class Something {
        // Some fields and methods
    }

    static class SecurityContextHolder {
        private static final ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<>();

        public static SecurityContext getContext() {
            SecurityContext context = contextHolder.get();
            if (context == null) {
                context = new SecurityContext();
                contextHolder.set(context);
            }
            return context;
        }
    }

    static class SecurityContext {
        private Authentication authentication;

        public Authentication getAuthentication() {
            return authentication;
        }

        public void setAuthentication(Authentication authentication) {
            this.authentication = authentication;
        }
    }

    static class Authentication {
        // Some fields and methods
    }

    static class ParallelStreamWithCustomExecutor<T> extends java.util.concurrent.ForkJoinTask<T> {
        private final ExecutorService executor;

        public ParallelStreamWithCustomExecutor(ExecutorService executor) {
            this.executor = executor;
        }

        @Override
        public T getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(T value) {
        }

        @Override
        protected boolean exec() {
            return false;
        }

        // Other methods to implement
    }

    public static void main(String[] args) {
        List<Something> listOfSomething = List.of(new Something(), new Something()); // Example list
        final int YOUR_THRESHOLD = 10; // Example threshold
        ExecutorService executor = Executors.newFixedThreadPool(4); // Example executor

        Stream<Something> stream = listOfSomething.stream();

        if (listOfSomething.size() > YOUR_THRESHOLD) {
            // If the size is larger than a certain threshold use parallel streams with our executor
            stream = stream.parallel().collect(Collectors.toCollection(() -> new ParallelStreamWithCustomExecutor<>(executor)));
        }

        stream.forEach(el -> {
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                throw new RuntimeException();
            }
        });

        executor.shutdown(); // Shutdown the executor after use
    }
}