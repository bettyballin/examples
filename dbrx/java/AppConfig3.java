import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.example")
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public MyAspect myAspect() {
        return new MyAspect();
    }

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = 
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);
        
        MyService myService = context.getBean(MyService.class);
        myService.performAction();
    }
}

@Component
class MyService {
    public void performAction() {
        System.out.println("Performing action in MyService");
    }
}

@Aspect
@Component
class MyAspect {

    @Before("execution(* *(..)) && target(com.example.MyService)")
    public void beforePerformAction() {
        System.out.println("Before performing action");
    }
}