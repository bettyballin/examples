import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutor;

public class Temp1537 {
    public static void main(String[] args) {
        ExecutorService executor = MoreExecutors.getExitingExecutorService(
            new DelegatingSecurityContextExecutor(ForkJoinPool.commonPool()), 60L, TimeUnit.SECONDS
        );
        
        // Example task submission to verify the executor works
        executor.submit(() -> System.out.println("Task executed"));

        executor.shutdown();
    }
}