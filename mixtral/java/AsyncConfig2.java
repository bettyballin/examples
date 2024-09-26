import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

  @Bean
  public TaskDecorator taskDecorator() {
      return CustomTaskDecorator::decorate;
  }

  @Bean
  public Executor asyncExecutor(TaskDecorator decorator) {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    // Configure your thread pool settings
    executor.setCorePoolSize(10);
    executor.setMaxPoolSize(20);
    executor.setQueueCapacity(50);
    executor.setThreadNamePrefix("AsyncExecutor-");
    executor.initialize();
    
    executor.setTaskDecorator(decorator);

    return executor;
  }
  
  public static class CustomTaskDecorator {
      public static Runnable decorate(Runnable runnable) {
          return () -> {
              // Custom decoration logic
              runnable.run();
          };
      }
  }
}