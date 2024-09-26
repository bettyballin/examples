import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Aspect
@Component
public class PreCheckAdvice {

    @Before("execution(* com.example.controller.*Controller.*(..))")
    public void doPreChecks(JoinPoint joinPoint) {
        // Perform pre-checks here e.g database calls or web-service calls.
        System.out.println("Pre-checks performed before method: " + joinPoint.getSignature().getName());
    }
}

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}



// Add @EnableAspectJAutoProxy to the Application class
@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}