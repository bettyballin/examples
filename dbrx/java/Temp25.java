import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Temp25 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit a simple task to the executor service for demonstration
        executorService.submit(() -> System.out.println("Task executed"));

        try {
            AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
                executorService.shutdown();
                return null; // nothing to return
            });
        } catch (AccessControlException e) {
            System.err.println("Failed to shutdown the Executor Service: " + e.getMessage());
        }
    }
}