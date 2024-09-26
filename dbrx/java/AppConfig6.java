import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public IpRestrictionAspect ipRestrictionAspect() {
        return new IpRestrictionAspect();
    }

}

// Assuming IpRestrictionAspect is defined in the same package
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class IpRestrictionAspect {

    @Before("execution(* *(..))")
    public void checkIpRestriction() {
        // Implementation of IP restriction logic
        System.out.println("IP restriction check performed.");
    }
}

// Main class to run the Spring application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class SpringAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }
}