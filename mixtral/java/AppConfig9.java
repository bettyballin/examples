import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    @Bean
    public SecurityAspect securityAspect() {
        return new SecurityAspect();
    }

    public static void main(String[] args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext context = 
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = context.getBean(MyService.class);
        myService.doSomething();
        context.close();
    }
}

@Aspect
@Component
class SecurityAspect {
    @Before("execution(* com.example.MyService.doSomething(..))")
    public void checkSecurity() {
        System.out.println("Security check performed.");
    }
}

@Component
class MyService {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}