import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.security.access.annotation.Secured;

public interface MyService {

    @PreAuthorize("hasPermission(#targetId, 'target')")
    void doSomething(@P("targetId") Long targetId);
}

// Implementation

@Service
public class MyServiceImpl implements MyService {

    @Override
    public void doSomething(Long targetId) {
        // Implementation here
        System.out.println("Doing something with targetId: " + targetId);
    }
}

// Main Application to test the code
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MyService myService) {
        return args -> {
            myService.doSomething(42L);
        };
    }
}