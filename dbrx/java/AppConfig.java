import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public SecurityAspect securityAspect() {
        return new SecurityAspect();
    }

    public static void main(String[] args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);

        MyService myService = context.getBean(MyService.class);
        myService.performOperation();
        context.close();
    }

    @Bean
    public MyService myService() {
        return new MyService();
    }
}

@Aspect
class SecurityAspect {

    @Before("execution(* *(..)) && within(MyService)")
    public void checkSecurity() {
        System.out.println("Security check performed");
    }
}

class MyService {

    public void performOperation() {
        System.out.println("Performing operation");
    }
}