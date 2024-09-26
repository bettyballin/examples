import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.task.DelegatingSecurityContextRunnable;

public class YourClass9 {

    private final TaskExecutor taskExecutor;

    public YourClass9() {
        this.taskExecutor = taskExecutor();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // Configure your executor as needed
        executor.initialize();
        return executor;
    }

    public void executeAsynchronously() {
        SecurityContext context = SecurityContextHolder.getContext();
        Runnable task = new DelegatingSecurityContextRunnable(() -> {
            // Your async code here
        }, context);
        taskExecutor.execute(task);
    }
}