import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Temp25 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        // ...

        try {
            AccessController.doPrivileged((PrivilegedExceptionAction<Object>) () -> {
                // Shutdown the thread pool
                executor.shutdown();

                if (!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)) {
                    executor.shutdownNow();
                }

                return null;
            });
        } catch (PrivilegedActionException e) {
            // Handle the exception
            System.err.println("Error while shutting down thread pool: " + e);

            if (!executor.isShutdown()) {
                executor.shutdownNow();
            }

            throw new RuntimeException(e);
        }
    }
}