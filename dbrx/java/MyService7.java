import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @Autowired
    private UserRepository userRepository;

    @Async("myExecutor")
    public CompletableFuture<ResponseEntity<MyResponseDto>> processRequest(MyUserDetails userDetails) throws InterruptedException {
        // Process your request here e.g call an external API or perform some heavy computation.
        Thread.sleep(35000);  // Simulate a long-running task.

        MyResponseDto response = new MyResponseDto();
        ResponseEntity<MyResponseDto> result = new ResponseEntity<>(response, HttpStatus.OK);

        return CompletableFuture.completedFuture(result);
    }
}

@Configuration
@EnableAsync
class AppConfig implements AsyncConfigurer {

    @Bean
    public ThreadPoolTaskExecutor myExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("my-thread-");
        executor.initialize();
        return executor;
    }
}

// Dummy classes to make the code executable
class UserRepository {
    // Implementation details
}

class MyUserDetails {
    // Implementation details
}

class MyResponseDto {
    // Implementation details
}