import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import javax.annotation.PostConstruct;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    private final ThreadPoolTaskExecutor delegate = new ThreadPoolTaskExecutor();

    @PostConstruct
    public void init() {
        delegate.setCorePoolSize(5);
        delegate.setMaxPoolSize(10);
        delegate.setQueueCapacity(25);
        delegate.initialize();
    }

    @Override
    public TaskExecutor getAsyncExecutor() {
        return delegate;
    }
}